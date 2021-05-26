package com.webservices.application;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJdbcRepositories("com.webservices.datarepository")
public class MySQLConnect extends AbstractJdbcConfiguration {

	@Bean
    NamedParameterJdbcOperations operations() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/web_services?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
    
    
	/*public static void main(String args[]){  
		String sqlSelectAllPersons = "SELECT * FROM user";
		String sqlInsertPerson = "INSERT INTO user (id_user, login, password, name, last_name, is_manager)"
				+ "VALUES (1, 'gab', 'gab1', 'Gabrielle', 'Faurie', 1)";
		String connectionUrl = "jdbc:mysql://localhost:3306/web_services?serverTimezone=UTC";
		//int result = 0;
		
		try {

			Connection conn = DriverManager.getConnection(connectionUrl, "root", ""); 
	        PreparedStatement ps = conn.prepareStatement(sqlInsertPerson); 
	        //ResultSet rs = ps.executeQuery();
	        int result = ps.executeUpdate();
		        while (rs.next()) {
		            long id = rs.getLong("id_user");
		            String name = rs.getString("name");
		            String lastName = rs.getString("LAST_NAME");
		            
		            System.out.println(id + name + lastName);

		            // do something with the extracted data...
		        }
			
			System.out.println(result);
		        
		} catch (SQLException e) {
			System.out.println(e);
		    // handle the exception
		}
	}*/
 	
}
