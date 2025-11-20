package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao  departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n=== TEST 1: department findById =======");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n=== TEST 2:  department findAll =======");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list ){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: department insert =======");
        Department newDep = new Department(null, "D2");
        departmentDao.insert(newDep);
        System.out.println("Inserted! New id: " +newDep.getId());

        System.out.println("\n=== TEST 4: department update =======");
        Department department2 = departmentDao.findById(1);
        department2.setName("Food");
        departmentDao.update(department2);
        System.out.println("Update completed");


        System.out.println("=== TEST 5: department delete =======");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");


        
    }
}
