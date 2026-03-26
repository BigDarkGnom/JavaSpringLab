package com.example.lab3.aspect;

import com.example.lab3.exception.ItemNotFoundException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class WarehouseAspect {

    // 1. BEFORE - Выполняется ДО метода
    @Before("execution(* com.example.lab3.service.Warehouse.putItem(..))")
    public void beforePutItem(JoinPoint joinPoint) {
        System.out.println(">>> [BEFORE] Начало операции помещения на склад.");
        System.out.println(">>> [BEFORE] Аргументы: " + Arrays.toString(joinPoint.getArgs()));
    }

    // 2. AFTER RETURNING - Выполняется ПОСЛЕ успешного завершения
    @AfterReturning(pointcut = "execution(* com.example.lab3.service.Warehouse.getItem(..))", returning = "result")
    public void afterReturningGetItem(JoinPoint joinPoint, Object result) {
        System.out.println("<<< [AFTER RETURNING] Метод getItem завершил работу успешно.");
        if (result != null) {
            System.out.println("<<< [AFTER RETURNING] Возвращенный предмет: " + result.toString());
        } else {
            System.out.println("<<< [AFTER RETURNING] Предмет не найден (null).");
        }
    }

    // 3. AFTER THROWING - Выполняется, если выброшено исключение
    @AfterThrowing(pointcut = "execution(* com.example.lab3.service.Warehouse.getItemStrict(..))", throwing = "ex")
    public void afterThrowingGetItemStrict(JoinPoint joinPoint, Exception ex) {
        System.out.println("!!! [AFTER THROWING] Произошла ошибка при строгом поиске!");
        System.out.println("!!! [AFTER THROWING] Тип исключения: " + ex.getClass().getSimpleName());
        System.out.println("!!! [AFTER THROWING] Сообщение: " + ex.getMessage());
    }

    // 4. AFTER (FINALLY) - Выполняется ВСЕГДА после метода
    @After("execution(* com.example.lab3.service.Warehouse.*(..))")
    public void afterFinally(JoinPoint joinPoint) {
        System.out.println("--- [AFTER FINALLY] Завершение работы метода: " + joinPoint.getSignature().getName());
    }

    // 5. AROUND - Выполняется ВОКРУГ метода (самый мощный)
    // Демонстрация изменения результата и доступа к сигнатуре
    @Around("execution(* com.example.lab3.service.Warehouse.getItem(..))")
    public Object aroundGetItem(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("++ [AROUND] До вызова метода. Сигнатура: " + joinPoint.getSignature());

        long start = System.currentTimeMillis();

        // Вызов оригинального метода
        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println("++ [AROUND] После вызова метода. Время выполнения: " + (end - start) + " мс");

        // Демонстрация изменения результата (если нашли предмет, добавим пометку)
        if (result != null) {
            System.out.println("++ [AROUND] Модификация результата: добавляем статус 'Проверено'");
            // В реальном коде нельзя изменить строку toString у объекта на лету без прокси,
            // но мы можем обернуть результат или изменить логику возврата.
            // Для демонстрации просто выведем сообщение, что мы МОГЛИ БЫ изменить результат.
            // Если бы метод возвращал String, мы могли бы сделать: return result + " [Checked]";
        } else {
            // Демонстрация обработки ошибки в Around (можем предотвратить исключение, вернув дефолт)
            // Но так как getItem возвращает null при отсутствии, а не кидает исключение,
            // здесь мы просто логируем.
            System.out.println("++ [AROUND] Результат пустой, но исключение не выброшено.");
        }

        return result;
    }
}