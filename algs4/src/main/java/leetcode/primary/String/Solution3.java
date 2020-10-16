package leetcode.primary.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lsf Time: 9/20/20-3:57 PM
 */
public class Solution3 {

  private Automaton automaton = new Automaton();

  /**
   * 方法一:FSM(状态机)
   *
   * @param str
   * @return
   */
  public int myAtoi(String str) {
    for (int i = 0; i < str.length(); i++) {
      automaton.request(str.charAt(i));
      if (automaton.getCurState() == "end") {
        break;
      }
    }
    return (int) automaton.getResult();
  }

  public static void main(String[] args) {
    Solution3 solution3 = new Solution3();
    String ans = "-9223372036854775809";
    solution3.myAtoi(ans);
  }
}

class Automaton {

  /**
   * 结果 and 符号位
   */
  public long res = 0;
  public int sign = 1;

  private String curState;
  private Map<String, String[]> stateTable = new HashMap<>();

  public Automaton() {
    this.curState = "start";
    stateTable.put("start", new String[]{"start", "signed", "in_number", "end"});
    stateTable.put("signed", new String[]{"end", "end", "in_number", "end"});
    stateTable.put("in_number", new String[]{"end", "end", "in_number", "end"});
    stateTable.put("end", new String[]{"end", "end", "end", "end"});
  }

  /**
   * 接受请求
   *
   * @param c
   */
  public void request(char c) {
    int k = judgeChar(c);
    curState = stateTable.get(curState)[k];
    switch (curState) {
      case "signed":
        if (c == '-') {
          sign = -1;
        }
        break;
      case "in_number":
        res = res * 10 + (c - '0');
        res = sign == 1?Math.min(res,(long) Integer.MAX_VALUE) : Math.min(res,-(long) Integer.MIN_VALUE);
        break;
    }
  }

  public int judgeChar(char c) {
    if (c == ' ') {
      return 0;
    } else if (c == '+' || c == '-') {
      return 1;
    } else if (c >= '0' && c <= '9') {
      return 2;
    } else {
      return 3;
    }
  }

  public long getResult() {
    return res * sign;
  }

  public String getCurState() {
    return curState;
  }
}