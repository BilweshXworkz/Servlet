package com.xworkz.exceloperation.excelrunner;

import com.xworkz.exceloperation.Entity.MyEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class DatabaseToExcel {
    private static final String excelPath = "E:\\X-Workz\\Servelet\\Servlet Connectivity\\Apache POI\\database-to-excel.xlsx";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("excel");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOutputStream = new FileOutputStream(new File(excelPath))) {

            List<MyEntity> entityList = entityManager.createQuery("SELECT e FROM MyEntity e", MyEntity.class).getResultList();

            Sheet sheet = workbook.createSheet("Database Data");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Name");
            headerRow.createCell(1).setCellValue("Age");
            headerRow.createCell(2).setCellValue("Email");

            int rowNum = 1;
            for (MyEntity entity : entityList) {
                Row row = sheet.createRow(rowNum++);

                Cell nameCell = row.createCell(0);
                nameCell.setCellValue(entity.getName() != null ? entity.getName() : "");

                Cell ageCell = row.createCell(1);
                ageCell.setCellValue(entity.getAge());

                Cell emailCell = row.createCell(2);
                emailCell.setCellValue(entity.getEmail() != null ? entity.getEmail() : "");
            }

            workbook.write(fileOutputStream);

            System.out.println("Data successfully written to Excel.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
