package com.example.lab3.service;

import com.example.lab3.exception.ItemNotFoundException;
import com.example.lab3.model.Storable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("singleton") // Явное указание области видимости
public class Warehouse {
    private final List<Storable> items = new ArrayList<>();

    // Метод основной логики
    public void putItem(Storable item) {
        System.out.println("[Warehouse] Предмет '" + item.getName() + "' помещается на склад...");
        items.add(item);
    }

    // Метод для демонстрации @AfterReturning и @Around
    public Storable getItem(String name) {
        System.out.println("[Warehouse] Поиск предмета: " + name);
        return items.stream()
                .filter(i -> i.getName().contains(name))
                .findFirst()
                .orElse(null);
    }

    // Метод для демонстрации @AfterThrowing (выбрасывает исключение)
    public Storable getItemStrict(String name) throws ItemNotFoundException {
        System.out.println("[Warehouse] Строгий поиск предмета: " + name);
        Storable item = items.stream()
                .filter(i -> i.getName().contains(name))
                .findFirst()
                .orElse(null);

        if (item == null) {
            throw new ItemNotFoundException("Предмет не найден: " + name);
        }
        return item;
    }

    public int getItemCount() {
        return items.size();
    }
}