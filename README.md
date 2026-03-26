# Лабораторные работы по курсу «Java Spring» 7 семестр Зайцев В.М

---

## Структура репозитория

---

## Лабораторная №1: Inversion of Control и Dependency Injection

- Создание Spring Boot-приложения
- Реализация IoC через `@Bean`
- Dependency Injection в классе `Employee`
- Персонализированный маршрут `/employee`:  

---

## Лабораторная №2: IoC и DI с аннотациями

- Использование аннотаций:  
  `@Component`, `@Autowired`, `@Qualifier`, `@Value`, `@Scope`, `@PostConstruct`, `@PreDestroy`
- Диагностические сообщения в конструкторах и методах жизненного цикла
- Два способа конфигурации:
  - Через сканирование компонентов
  - Через Java-класс `@Configuration`

---

## Лабораторная №3: Aspect-Oriented Programming (AOP)

- Создание склада (`Warehouse`) и предметов (`Apple`, `Chair`, `Laptop`)
- Реализация всех 5 типов Advice:
  - `@Before`
  - `@AfterReturning`
  - `@AfterThrowing`
  - `@After`
  - `@Around`
- Логирование и модификация поведения методов

---

## Лабораторные №4, №5, №6: Единая система ветеринарной клиники (`lab456`)

### Лабораторная №4: Hibernate
- Модель данных: `Pet`, `Owner`, `Specialist`, `MedicalRecord`
- Связи:
  - **Один к одному**: `Pet` ↔ `MedicalRecord`
  - **Один ко многим**: `Specialist` → `Pet`
  - **Многие ко многим**: `Owner` ↔ `Pet`
- Демонстрация типов загрузки (`LAZY` / `EAGER`)

### Лабораторная №5: Spring MVC + Thymeleaf
- Интерактивные формы с:
  - `text input`
  - `select`
  - `radio button`
  - `checkbox`
- Валидация через `@NotBlank`, `@Size`

### Лабораторная №6: Spring REST + Hibernate
- Полноценный REST API:
  - `/api/pets`, `/api/owners`, `/api/specialists`, `/api/medical-records`
- Поддержка CRUD-операций
- Защита от циклических ссылок через `@JsonIgnore`
- Инициализация тестовых данных — включая **автора как владельца**

---

## Технологии

- **Java 21+**
- **Spring Boot 3.3.x**
- **Spring Core, Spring Web, Spring Data JPA, Spring AOP**
- **Hibernate**
- **Thymeleaf**
- **H2 Database** (встроенная, в памяти)
- **Jakarta Validation**
- **Maven**

---
