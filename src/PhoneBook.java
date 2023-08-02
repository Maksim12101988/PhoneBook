
/*
import java.util.*;

public class PhoneBook {
    private HashMap<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    // Другие методы класса: добавление контакта, получение списка телефонов и т.д.
    public void addContact(String name, String phone) {
        if (contacts.containsKey(name)) {
            List<String> phoneList = contacts.get(name);
            phoneList.add(phone);
        } else {
            List<String> phoneList = new ArrayList<>();
            phoneList.add(phone);
            contacts.put(name, phoneList);
        }
    }
    public List<String> getPhoneNumbers(String name) {
        if (contacts.containsKey(name)) {
            return contacts.get(name);
        } else {
            return Collections.emptyList(); // Возвращаем пустой список, если контакт не найден
        }
    }
    public List<Map.Entry<String, List<String>>> sortContactsByPhoneNumberCount() {
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(contacts.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());
        return sortedEntries;
    }
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Иван", "12345");
        phoneBook.addContact("Мария", "67890");
        phoneBook.addContact("Иван", "54321");
        phoneBook.addContact("Алексей", "98765");

        List<Map.Entry<String, List<String>>> sortedContacts = phoneBook.sortContactsByPhoneNumberCount();

        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
*/
import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем HashMap для хранения контактов
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Вводим данные через консоль
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите имя контакта ('q' для выхода): ");
            String name = scanner.nextLine();
            if (name.equals("q")) {
                break;
            }

            System.out.print("Введите номер телефона контакта: ");
            String phone = scanner.nextLine();

            // Если в телефонной книге уже есть контакт с таким именем,
            // добавляем номер телефона к существующему контакту
            if (phoneBook.containsKey(name)) {
                List<String> phones = phoneBook.get(name);
                phones.add(phone);
                phoneBook.put(name, phones);
            } else {
                // Если нет, создаем новую запись с именем и номером телефона
                List<String> phones = new ArrayList<>();
                phones.add(phone);
                phoneBook.put(name, phones);
            }
        }

        // Выводим контакты в порядке убывания числа телефонов
        System.out.println("Список контактов:");
        phoneBook.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });
    }
}
