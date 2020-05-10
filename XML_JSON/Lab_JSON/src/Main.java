import java.io.*;

import org.json.simple.*;
import org.json.simple.parser.*;

/**
 * JSON - FPT Aptech - 20/05/2020
 * http://codelean.vn/2020/04/mlj09-gioi-thieu-ve-json.html
 * http://codelean.vn/2020/04/mlj10-oc-file-json-bang-java.html
 * http://codelean.vn/2020/04/mlj11-json-vs-xml-example.html
 * http://codelean.vn/2020/05/mlj12-vi-du-ve-json-va-xml.html
 * http://codelean.vn/2020/04/mlj13-oc-ghi-file-json-trong-java.html
 */
public class Main {
    public static void main(String[] args) {
        //Example_Course();

        //MLJ_11_Bai_1();

        //- MLJ_13
        //WriteJSONTest();
        //ReadJSONTest();
    }

    private static void Example_Course() {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("src/MLJ_10/course.json"));

            System.out.println("JSON Object: " + obj);

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("Name");
            String course = (String) jsonObject.get("Course");
            JSONArray subjects = (JSONArray) jsonObject.get("Subjects");

            System.out.println("Name: " + name);
            System.out.println("Course:" + course);
            System.out.println("Subjects:");

//            Iterator iterator = subjects.iterator();
//            while (iterator.hasNext()) {
//                System.out.println("\t" + iterator.next());
//            }

            for (var item : subjects) {
                System.out.println("\t" + item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void MLJ_11_Bai_1() {
        try {
            //Lấy chuỗi JSON từ file
            JSONParser jsonParser = new JSONParser();
            FileReader fileReader = new FileReader("src/MLJ_11/Bai_1.json");
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            System.out.println("JSON String: " + jsonObject);

            //lấy JSONObject gốc: "menu", và các thuộc tính con trong "menu"
            JSONObject menu = (JSONObject) jsonObject.get("menu");
            String id = (String) menu.get("id");

            System.out.println("id: " + id);
            System.out.println("value: " + menu.get("value"));

            //lấy JSONObject con: "popup" | Mảng: "menuitem"
            JSONObject popup = (JSONObject) menu.get("popup");
            JSONArray menuitem = (JSONArray) popup.get("menuitem");

            System.out.println("Menu Item: ");
            for (var item : menuitem) {
                var item_JSONObject = (JSONObject) item;
                System.out.println("\t" + "onclick: " + item_JSONObject.get("onclick") +
                        ", value: " + item_JSONObject.get("value"));
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static void WriteJSONTest() {
        //Employee_1
        JSONObject jsonObject_Employee_1 = new JSONObject();
        jsonObject_Employee_1.put("firstName", "Dang");
        jsonObject_Employee_1.put("lastName", "Kim Thi");
        jsonObject_Employee_1.put("website", "codelean.vn");

        //Employee_2
        JSONObject jsonObject_Employee_2 = new JSONObject();
        jsonObject_Employee_2.put("firstName", "Nguyen");
        jsonObject_Employee_2.put("lastName", "Dinh Hieu");
        jsonObject_Employee_2.put("website", "hieu-icetea.github.io");

        //Array
        JSONArray jsonArray_Employee = new JSONArray();
        jsonArray_Employee.add(jsonObject_Employee_1);
        jsonArray_Employee.add(jsonObject_Employee_2);

        //Employees
        JSONObject jsonObject_Employees = new JSONObject();
        jsonObject_Employees.put("Employees", jsonArray_Employee);

        //String JSON Employees
        String strJSON_Employees = jsonObject_Employees.toJSONString();
        System.out.println("strJSON_Employees: " + strJSON_Employees);

        //Write JSON file
        try (FileWriter fileWriter = new FileWriter("src/MLJ_13/employees.json")) {

            fileWriter.write(strJSON_Employees);
            fileWriter.flush();

            System.out.println("Success!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ReadJSONTest() {
        try {
            //ĐỌc file và lấy objectJSON
            FileReader fileReader = new FileReader("src/MLJ_13/employees.json");
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            System.out.println("jsonObject: " + jsonObject);

            //Lấy mảng ở trong object
            JSONArray jsonArray = (JSONArray) jsonObject.get("Employees");

            //Duyệt mảng và gọi hàm hiện thị
            for (var item : jsonArray) {
                parseEmployeeObject((JSONObject) item);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseEmployeeObject(JSONObject employee) {
        String firstName = (String) employee.get("firstName");
        String lastName = (String) employee.get("lastName");
        String website = (String) employee.get("website");

        System.out.println("FullName: " + firstName + ", " + lastName +
                "\n\tWebsite: " + website);
    }
}