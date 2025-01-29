package com.xworkz.exceloperation.excelrunner;

import com.xworkz.exceloperation.Entity.MyEntity;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelToDatabase {
    private static final String excelPath = "E:\\X-Workz\\Servelet\\Servlet Connectivity\\Apache POI\\excel-database.xlsx";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("excel");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try (FileInputStream fileInputStream = new FileInputStream(new File(excelPath));
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            entityManager.getTransaction().begin();

            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (row.getRowNum() == 0) continue;

                MyEntity entity = new MyEntity();
                if (row.getCell(0) != null && row.getCell(0).getCellType() == org.apache.poi.ss.usermodel.CellType.STRING) {
                    entity.setName(row.getCell(0).getStringCellValue());
                } else {
                    entity.setName("");
                }
                if (row.getCell(1) != null && row.getCell(1).getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC) {
                    entity.setAge((int) row.getCell(1).getNumericCellValue());
                } else {
                    entity.setAge(0);
                }
                if (row.getCell(2) != null && row.getCell(2).getCellType() == org.apache.poi.ss.usermodel.CellType.STRING) {
                    entity.setEmail(row.getCell(2).getStringCellValue());
                } else {
                    entity.setEmail("");
                }

                entityManager.persist(entity);
            }

            entityManager.getTransaction().commit();
            System.out.println("Data Transferred.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
