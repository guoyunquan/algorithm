package org.gyq.hash;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * <p>
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 解释：
 * <p>
 * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
 * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * <p>
 * 输出: [[""]]
 * <p>
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * <p>
 * 输出: [["a"]]
 */
public class Top_Two {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String index = sortFont(str);
            if (map.containsKey(index)) {
                List<String> indexList = map.get(index);
                indexList.add(str);
                map.put(index, indexList);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(index, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public String sortFont(String words) {
        char[] charArray = words.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) {
        Top_Two topTwo = new Top_Two();
        String[] ag = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = topTwo.groupAnagrams(ag);
        for (List<String> stringList : list) {
            System.out.println(stringList);
        }

    }

}
