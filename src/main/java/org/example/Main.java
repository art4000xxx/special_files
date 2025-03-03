package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

public class Main {

    public static void main(String[] args) {
        // Задача 3 (JSON -> Java)
        String json = readString("new_data.json");
        List<Employee> list3 = jsonToList(json);

        // Вывод в консоль
        for (Employee employee : list3) {
            System.out.println(employee);
        }
    }

    // Метод для чтения строки из файла
    public static String readString(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    // Метод для преобразования JSON в список объектов
    public static List<Employee> jsonToList(String json) {
        List<Employee> employees = new ArrayList<>();
        JsonParser parser = new JsonParser();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        JsonArray jsonArray = parser.parse(json).getAsJsonArray();

        for (com.google.gson.JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            Employee employee = gson.fromJson(jsonObject, Employee.class);
            employees.add(employee);
        }

        return employees;
    }

    // Остальные методы (parseCSV, listToJson, writeString, parseXML) остаются без изменений
    // ...

    // Метод для преобразования списка в JSON (уже есть из предыдущей задачи)
    public static String listToJson(List<Employee> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        return gson.toJson(list, listType);
    }

    // Метод для записи строки в файл (уже есть из предыдущей задачи)
    public static void writeString(String json, String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> parseXML(String fileName) {
        List<Employee> employees = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fileName));

            // Получаем корневой элемент
            Element root = doc.getDocumentElement();

            // Получаем список всех элементов employee
            NodeList employeeNodes = root.getElementsByTagName("employee");

            for (int i = 0; i < employeeNodes.getLength(); i++) {
                Element employeeElement = (Element) employeeNodes.item(i);

                // Получаем значения элементов
                long id = Long.parseLong(employeeElement.getElementsByTagName("id").item(0).getTextContent());
                String firstName = employeeElement.getElementsByTagName("firstName").item(0).getTextContent();
                String lastName = employeeElement.getElementsByTagName("lastName").item(0).getTextContent();
                String country = employeeElement.getElementsByTagName("country").item(0).getTextContent();
                int age = Integer.parseInt(employeeElement.getElementsByTagName("age").item(0).getTextContent());

                // Создаем объект Employee
                Employee employee = new Employee(id, firstName, lastName, country, age);
                employees.add(employee);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

    // Метод для парсинга CSV файла
    public static List<Employee> parseCSV(String[] columnMapping, String fileName) {
        // TODO
        return null;
    }
}