public class taskTarget {
    public static void main(String[] args) {
        StringBuilder targetStr = new StringBuilder();
        String[] Str = {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"};
        int len = Str.length;
        for (int i = 0; i < len; i++) {
            if (Str[i].indexOf("null") == (-1)) {
                targetStr.append(Str[i].replace(":", "="));
                if (i != len - 2) {
                    targetStr.append(",");
                }
            }
        }
        System.out.println("Ваш запрос обработан: "+targetStr);
    }
}

