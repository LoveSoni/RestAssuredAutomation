package Utilities;

import java.util.HashMap;
import java.util.Map;

public class TokenInitialise {

  public static Map getAuth() {
    Map<String, Object> map = new HashMap<>();
    map.put("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
    return map;
  }

}
