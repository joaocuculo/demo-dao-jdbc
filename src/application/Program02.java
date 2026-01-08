/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

/**
 *
 * @author Usuario
 */
public class Program02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department insert ===");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("=== TEST 2: department finById ===");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("=== TEST 3: department update ===");
        department = departmentDao.findById(1);
        department.setName("Food");
        departmentDao.update(department);
        System.out.println("Update completed.");

        System.out.println("=== TEST 4: department delete ===");
        System.out.print("Enter id for delete test:");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed.");

        System.out.println("=== TEST 5: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list) {
            System.out.println(dep);
        }
    }
}
