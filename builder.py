class Outfit:
    def __init__(self):
        self.items = []

    def add(self, item):
        self.items.append(item)

    def get_total_cost(self):
        return sum(item.get_cost() for item in self.items)

    def __str__(self):
        text = "Outfit:\n"
        text += "\n".join(str(item) for item in self.items)
        text += f"\nTotal Cost: ${self.get_total_cost():.2f}"
        return text


class ClothingItem:
    def __init__(self, name, cost):
        self.name = name
        self.cost = cost

    def get_cost(self):
        return self.cost

    def __str__(self):
        return f"{self.name}: ${self.cost:.2f}"


class OutfitBuilder:
    def __init__(self):
        self.outfit = Outfit()

    def add_top(self):
        pass

    def add_bottom(self):
        pass

    def add_shoes(self):
        pass

    def add_accessory(self):
        pass

    def reset(self):
        self.outfit = Outfit()

    def get_outfit(self):
        return self.outfit


class CasualOutfitBuilder(OutfitBuilder):
    def add_top(self):
        self.outfit.add(ClothingItem("Camiseta de algodón", 15.99))

    def add_bottom(self):
        self.outfit.add(ClothingItem("Jeans ajustados", 39.99))

    def add_shoes(self):
        self.outfit.add(ClothingItem("Zapatillas deportivas", 49.99))

    def add_accessory(self):
        self.outfit.add(ClothingItem("Reloj casual", 25.99))


class OutfitDirector:
    def __init__(self, builder):
        self.builder = builder

    def construct_full_outfit(self):
        self.builder.reset()
        self.builder.add_top()
        self.builder.add_bottom()
        self.builder.add_shoes()
        self.builder.add_accessory()

    def construct_basic_outfit(self):
        self.builder.reset()
        self.builder.add_top()
        self.builder.add_bottom()


# Prueba del código
casual_builder = CasualOutfitBuilder()
outfit_director = OutfitDirector(casual_builder)
outfit_director.construct_full_outfit()
print(casual_builder.get_outfit())

formal_builder = CasualOutfitBuilder()
formal_director = OutfitDirector(formal_builder)
formal_director.construct_basic_outfit()
print(formal_builder.get_outfit())
