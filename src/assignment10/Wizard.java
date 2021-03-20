package assignment10;

import java.util.ArrayList;
import java.util.List;

public class Wizard {
    private int dragonSkin;
    private int feathers;
    private int essence;
    private final int MIN_PRICE;
    List<Materials> items = new ArrayList<>();

    public Wizard(int dragonSkin, int feathers, int essence, int MIN_PRICE) {
        this.dragonSkin = dragonSkin;
        this.feathers = feathers;
        this.essence = essence;
        this.MIN_PRICE = MIN_PRICE;
    }
//    normal quality: needs 2x dragonskin, 1x feather and 1x magical essence.
//    epic quality: need 5x dragonskin, 2x feather and 3x magical essence.
//    legendary quality: needs 8x dragonskin, 10x feather and 8x magical essence

    public int craft(){
        boolean stopRecursion = false;
        if (dragonSkin >= 8 && feathers >=10 && essence >= 8){
            dragonSkin-=8;
            feathers-=10;
            essence-=8;
            items.add(Materials.LEGENDARY_QUALITY);
        } else if (dragonSkin >= 5 && feathers >=2 && essence >= 3){
            dragonSkin-=5;
            feathers-=2;
            essence-=3;
            items.add(Materials.EPIC_QUALITY);
        }else if (dragonSkin >= 2 && feathers >=1 && essence >= 1){
            dragonSkin-=2;
            feathers-=1;
            essence-=1;
            items.add(Materials.NORMAL_QUALITY);
        }
        else {
            stopRecursion= true;
        }



        if (!stopRecursion){
            craft();
        }
            return items.size();

    }

    public boolean doSell(int offer){
//        id like to remove a material from the list, but this assignment doesnt say which material wizard wants to sell
//        so ill sell starting from the worst materials cuz a good wizard doesnt want to lose higher quality materials first

//        checking if wizard even has any materials
        if (MIN_PRICE <= offer && items.size() >0){

            if (items.contains(Materials.NORMAL_QUALITY)){
                items.removeIf(x -> x.equals(Materials.NORMAL_QUALITY));
            }else if(items.contains(Materials.EPIC_QUALITY)){
                items.removeIf(x -> x.equals(Materials.EPIC_QUALITY));
            }else if(items.contains(Materials.LEGENDARY_QUALITY)){
                items.removeIf(x -> x.equals(Materials.LEGENDARY_QUALITY));
            }

            return true;
        }
        else{
            return false;
        }
    }

    public String displayInventory() {
//        “Materials:\n
//        Fireproof Dragonskin x$amount; Golden Feathers x$amount; Magical Essence x$amount;\n
//        Items:\n
//        Normal x$amount; Epic x$amount; Legendary x$amount;\n”

        int normalNumber= (int) items.stream().filter(o -> (o.equals(Materials.NORMAL_QUALITY))).count();
        int epicNumber= (int) items.stream().filter(o -> (o.equals(Materials.EPIC_QUALITY))).count();
        int legendaryNumber= (int) items.stream().filter(o -> (o.equals(Materials.LEGENDARY_QUALITY))).count();

        return "Materials:\n" +
                "Fireproof Dragonskin x" + dragonSkin +
                "; Golden Feathers x" + feathers +
                "; Magical Essence x" + essence +
                ";\nItems:\n"+
                "Normal x" + normalNumber +
                "; Epic x" + epicNumber +
                "; Legendary x" + legendaryNumber +
                "; \n";
    }


}
