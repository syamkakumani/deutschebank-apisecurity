package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

	@GetMapping("/company/{companyId}")
	String companyInfo(@PathVariable String companyId) throws ClassNotFoundException, SQLException {
		StringBuffer sb = new StringBuffer();

		Class.forName("org.h2.Driver");

		Connection con = DriverManager.getConnection("jdbc:h2:mem:company_data", "sa", "");
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM company where id = ? ");
		stmt.setInt(1, Integer.valueOf(companyId));
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int compId = rs.getInt(1);
			String companyName = rs.getString(2);

			sb.append("( " + compId + "," + companyName + " )");
		}

		return sb.toString();
	}

	@GetMapping("/company-old/{companyId}")
	String companyInfoOld(@PathVariable String companyId) throws ClassNotFoundException, SQLException {
		StringBuffer sb = new StringBuffer();

		Class.forName("org.h2.Driver");

		Connection con = DriverManager.getConnection("jdbc:h2:mem:company_data", "sa", "");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM company where id = " + companyId);

		while (rs.next()) {
			int compId = rs.getInt(1);
			String companyName = rs.getString(2);

			sb.append("( " + compId + "," + companyName + " )");
		}

		return sb.toString();
	}

	@GetMapping("/create-table")
	String createTable() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");

		Connection con = DriverManager.getConnection("jdbc:h2:mem:company_data", "sa", "");
		Statement stmt = con.createStatement();
		stmt.execute("CREATE TABLE company(ID INT PRIMARY KEY auto_increment, company_name VARCHAR(255))");

		return "Table created successfully !!";
	}
}
