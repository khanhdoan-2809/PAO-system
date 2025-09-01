import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, Pao> paoMap = preparePaoMap();

    public static void main(String[] args) {
        var numbers = new ArrayList<String>();
        numbers.add("0970696870");
        numbers.add("0910776977");

        numbers.forEach(number -> {
            var result = calculatePao(number);
            System.out.printf("number: %s: \n-> %s\n\n", number, result);
        });
    }

    private static String calculatePao(String number) {
        var type = PaoType.NAME;
        var result = new StringBuilder();
        for (var i = 0; i < number.length() - 1; i += 2) {
            var key = number.charAt(i) + "" + number.charAt(i + 1);
            var pao = paoMap.get(key);
            if (pao == null) {
                System.out.printf("Not found: %s", key);
                return "";
            }

            switch (type) {
                case NAME -> {
                    result.append(String.format("%s ", pao.name()));
                    type = PaoType.ACTION;
                }
                case ACTION -> {
                    result.append(String.format("%s ", pao.action()));
                    type = PaoType.OBJECT;
                }
                case OBJECT -> {
                    result.append(String.format("%s ", pao.object()));
                    type = PaoType.NAME;
                }
            }
        }
        return result.toString();
    }

    private static Map<String, Pao> preparePaoMap() {
        var paoMap = new HashMap<String, Pao>();

        var paos = new ArrayList<Pao>();

        paos.add(new Pao("09", "Oberyn", "Dance", "Spear"));

        paos.add(new Pao("10", "Messi", "Dribble", "Ball"));

        paos.add(new Pao("68", "Sherlock Holmes", "Looking", "Magnifying Glass"));
        paos.add(new Pao("69", "Snape", "Spell", "Wand"));

        paos.add(new Pao("70", "Go lang", "code", "Computer"));
        paos.add(new Pao("74", "GD", "Sing", "Micro"));
        paos.add(new Pao("77", "GG", "Searching", "Website"));


        paos.forEach(pao -> paoMap.put(pao.key(), pao));

        return paoMap;
    }

}
