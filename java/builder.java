import java.util.ArrayList;
import java.util.List;

// Clase que representa un Outfit (conjunto de prendas)
class Outfit {
    private List<ClothingItem> items;

    public Outfit() {
        items = new ArrayList<>();
    }

    public void add(ClothingItem item) {
        items.add(item);
    }

    public double getTotalCost() {
        double total = 0;
        for (ClothingItem item : items) {
            total += item.getCost();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Outfit:\n");
        for (ClothingItem item : items) {
            sb.append(item).append("\n");
        }
        sb.append(String.format("Total Cost: $%.2f", getTotalCost()));
        return sb.toString();
    }
}

// Clase que representa una prenda de ropa
class ClothingItem {
    private String name;
    private double cost;

    public ClothingItem(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("%s: $%.2f", name, cost);
    }
}

// Clase abstracta Builder para construir un Outfit
abstract class OutfitBuilder {
    protected Outfit outfit;

    public OutfitBuilder() {
        outfit = new Outfit();
    }

    public abstract void addTop();
    public abstract void addBottom();
    public abstract void addShoes();
    public abstract void addAccessory();

    public void reset() {
        outfit = new Outfit();
    }

    public Outfit getOutfit() {
        return outfit;
    }
}

// Implementación concreta de un builder para un Outfit casual
class CasualOutfitBuilder extends OutfitBuilder {
    @Override
    public void addTop() {
        outfit.add(new ClothingItem("Camiseta de algodón", 15.99));
    }

    @Override
    public void addBottom() {
        outfit.add(new ClothingItem("Jeans ajustados", 39.99));
    }

    @Override
    public void addShoes() {
        outfit.add(new ClothingItem("Zapatillas deportivas", 49.99));
    }

    @Override
    public void addAccessory() {
        outfit.add(new ClothingItem("Reloj casual", 25.99));
    }
}

// Director que utiliza el builder para construir diferentes outfits
class OutfitDirector {
    private OutfitBuilder builder;

    public OutfitDirector(OutfitBuilder builder) {
        this.builder = builder;
    }

    // Construye un outfit completo: top, bottom, shoes y accessory.
    public void constructFullOutfit() {
        builder.reset();
        builder.addTop();
        builder.addBottom();
        builder.addShoes();
        builder.addAccessory();
    }

    // Construye un outfit básico: solo top y bottom.
    public void constructBasicOutfit() {
        builder.reset();
        builder.addTop();
        builder.addBottom();
    }
}

// Clase pública con método main para ejecutar el código
public class builder {
    public static void main(String[] args) {
        // Construcción de un outfit completo (casual)
        OutfitBuilder casualBuilder = new CasualOutfitBuilder();
        OutfitDirector director = new OutfitDirector(casualBuilder);
        director.constructFullOutfit();
        System.out.println(casualBuilder.getOutfit());

        System.out.println(); // Línea en blanco para separar salidas

        // Construcción de un outfit básico (casual)
        OutfitBuilder basicBuilder = new CasualOutfitBuilder();
        OutfitDirector basicDirector = new OutfitDirector(basicBuilder);
        basicDirector.constructBasicOutfit();
        System.out.println(basicBuilder.getOutfit());
    }
}
