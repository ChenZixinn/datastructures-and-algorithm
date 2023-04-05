package com.tzuxin.datastructures.tree.huffmancode;


import java.io.*;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();

//        // 压缩
//        byte[] huffman = huffmanZip(contentBytes);
//        System.out.println(Arrays.toString(huffman));
//
//        // 解压
//        byte[] decode = decode(huffmanCode, huffman);
//        for (byte b : decode) {
//            System.out.print((char)b);
//        }

        // 压缩文件
//        zipFile("src/test/java/src.png", "src/test/java/src.zip");

        // 解压文件
        unZipFile("src/test/java/src.zip", "src/test/java/testUnZip.png");
    }
    // 存放哈夫曼编码表
    static Map<Byte, String> huffmanCode = new HashMap<>();
    // 存放路径
    static StringBuilder path = new StringBuilder();
    // 记录最后一位的长度，因为最后一个可能不足8位，需要考虑补0的问题
    static int lastCodeLen;


    private static void unZipFile(String src, String out) {
        InputStream is = null;
        OutputStream os = null;
        ObjectInputStream ois = null;
        try {
            is = new FileInputStream(src);
            ois = new ObjectInputStream(is);
            os = new FileOutputStream(out);

            // 读取字节数组
            byte[] huffmanBytes = (byte[]) ois.readObject();
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            lastCodeLen = (int) ois.readObject();

            byte[] decode = decode(huffmanCodes, huffmanBytes);
            os.write(decode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                is.close();
                os.close();
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 压缩文件
     *
     * @param srcFile 要压缩的文件
     * @param outFile 文件输出路径
     */
    public static void zipFile(String srcFile, String outFile) {
        // 输入流
        FileInputStream is = null;
        // 输出流
        OutputStream os = null;
        // 对象输出流
        ObjectOutputStream oos = null;
        try {
            is = new FileInputStream(srcFile);
            os = new FileOutputStream(outFile);
            oos = new ObjectOutputStream(os);
            byte[] b = new byte[is.available()];
            is.read(b);
            byte[] huffmanBytes = huffmanZip(b);
            // 写入压缩后的字符数组
            oos.writeObject(huffmanBytes);
            // 写入哈夫曼编码
            oos.writeObject(huffmanCode);
            // 写入最后一个字节的长度
            oos.writeObject(lastCodeLen);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
                os.close();
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 对哈夫曼编码进行解码操作
     *
     * @param huffmanCode  哈夫曼编码表
     * @param huffmanBytes 编码后的字节数组
     * @return 解码后的字节数组
     */
    public static byte[] decode(Map<Byte, String> huffmanCode, byte[] huffmanBytes) {
        StringBuilder str = new StringBuilder();
        byte b;
        // 字节处理除最后一位外所有数据
        for (int i = 0; i < huffmanBytes.length - 1; i++) {
            str.append(byte2BitString(huffmanBytes[i], true));
        }
        // 单独处理一下最后一位byte
        b = huffmanBytes[huffmanBytes.length - 1];
        String lastByteStr = byte2BitString(b, false);
        // 如果长度相等，那正好。拼接上去
//        System.out.println("最后一位长度:" + lastCodeLen);
        if (lastByteStr.length() == lastCodeLen) {
            str.append(lastByteStr);
        } else {
            // 如果长度不够，那就先补0，直到总长度相等，再拼接
            while ((str.length() + lastByteStr.length()) % 8 < lastCodeLen) {
                str.append(0);
            }
            str.append(lastByteStr);
        }
//        System.out.println("解码后的哈夫曼编码字符串为：" + str.toString() + "长度为：" + str.length());
        // 然后对应原先的map表 i=100 反转 制定新的map表 100 =i
        Map<String, Byte> map = new HashMap<String, Byte>();
        for (Map.Entry<Byte, String> entry : huffmanCode.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        // 扫描上面的code字符串，对应出单词空格保存到list中
        List<Byte> list = new ArrayList<>();
        for (int j = 0; j < str.length(); ) {
            // i只是前进所用，真正扫描寻找到有为止，还需要一个索引
            int count = 1;
            // 遍历查找的结束标识
            boolean flag2 = true;
            String subStr = null;
            // 注意越界判断
            while (flag2 && (j + count) <= str.length()) {
                // 截取子串，进行map中key值比较
                subStr = str.substring(j, j + count);
                // b2 = map.get(subStr);
                if (map.containsKey(subStr)) {
                    flag2 = false;
                } else {
                    // 没有的话继续遍历后移
                    count++;
                }
            }
            // 将这个byte添加到list中
            list.add(map.get(subStr));
            // 查找到一个后，后移到下一个j起始处.此处后移了j那么for中就不要再后移了
            j += count;
        }
        // 扫描完所有的字符串，将list中的数据转化成byte[]
        byte[] bt = new byte[list.size()];
        for (int i = 0; i < bt.length; i++) {
            bt[i] = list.get(i);
        }
        return bt;
    }


    /**
     * 将字节数组转化为二进制字符串
     *
     * @param b    字节数组
     * @param flag 是否需要补高位，正数需要补，最后一位不补
     * @return 二进制字符串
     */
    public static String byte2BitString(byte b, boolean flag) {
        int temp = b;
        if (flag) {
            temp |= 256;  // 按位或256  1000 0000 | 0000 0001 => 1000 0001
        }
        String str = Integer.toBinaryString(temp);
        if (flag || temp < 0) {
            // true 就是还没到末尾 都是8位 以及负数的情况
            // 但是注意！负数转化完是int类型32位的二进制补码--所以需要取出后8位
            return str.substring(str.length() - 8);
        }
        // false 到了末尾值，正数，不足8位，直接返回该有的长度就可以。
        return str;
    }


    private static byte[] huffmanZip(byte[] contentBytes) {
        // 将字节数组统计个数后生成Node对象, 构建哈夫曼树
        Node huffmanTreeRoot = createHuffmanTree(getNodes(contentBytes));
        // 构建哈夫曼编码
        getCodes(huffmanTreeRoot);
        // 传入数组和编码表，返回压缩后的数组
        return zip(contentBytes, huffmanCode);
    }

    /**
     * 传入数组和编码表，返回压缩后的数组
     *
     * @param bytes       原始数据
     * @param huffmanCode 哈夫曼编码表
     * @return 压缩后的数据
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCode) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(huffmanCode.get(b));
        }

//        System.out.println(data.toString()); // 10101000101111111100100...

        // 将得到的编码转为byte数组
        // 判断数组长度，每个byte数组可以存8个数据
        int len = (sb.length() + 7) / 8;
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            String strByte;
            if (i + 8 > sb.length()) {
                strByte = sb.substring(i);
                lastCodeLen = strByte.length();
                while (strByte.length() < 8) {
                    strByte = "0" + strByte;
                }
            } else {
                strByte = sb.substring(i, i + 8);
            }
//            System.out.println(strByte);
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    // 重载
    public static Map<Byte, String> getCodes(Node node) {
        if (node == null) {
            return null;
        }
        getCodes(node, "", path);
        return huffmanCode;
    }

    /**
     * 构建哈夫曼编码
     *
     * @param node 节点
     * @param code 节点对应的路径，左节点为0，右节点为1
     * @param path 先前的路径
     */
    public static void getCodes(Node node, String code, StringBuilder path) {
        // 拼接路径
        StringBuilder newPath = new StringBuilder(path);
        newPath.append(code);
        if (node != null) {
            // 如果不是叶子节点，就左右递归
            if (node.data == null) {
                getCodes(node.left, "0", newPath);
                getCodes(node.right, "1", newPath);
            } else {
                // 如果是叶子节点，存放进表中
                huffmanCode.put(node.data, newPath.toString());
            }
        }

    }

    /**
     * 将字节数组统计个数后生成Node对象，并放入list中
     *
     * @param bytes 字节数组
     * @return 存放了Node对象的列表
     */
    public static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (Byte b : bytes) {
            Integer count = counts.getOrDefault(b, 0);
            if (count == 0) {
                counts.put(b, 1);
            } else {
                counts.put(b, ++count);
            }
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }


    /**
     * 构建哈夫曼树
     *
     * @param nodes 包含所有节点的列表
     * @return 哈夫曼树root节点
     */
    public static Node createHuffmanTree(List<Node> nodes) {
        // 当剩下最后一个节点时即为完成
        while (nodes.size() > 1) {
            // 排序
            // node实现了comparable接口
            Collections.sort(nodes);
            // 取出数组第一个和第二个节点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            // 删除原来的节点，加入新的节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        // 此处的节点即为哈夫曼树
        return nodes.get(0);
    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        }
    }
}


class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // 升序排序
        return this.weight - o.weight;
    }
}
