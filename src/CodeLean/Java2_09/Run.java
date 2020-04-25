package CodeLean.Java2_09;

import MyUtilities.Utility;
//import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.*;

/**
 * [Java2_09] More JDBC <br>
 * http://www.codelean.vn/2020/04/java209-more-jdbc.html
 */
public class Run {
    public static void main(String[] args) {
        // >> Atomic Transaction
        //JdbcCommitTest();
        //JdbcCommitCatchTest();

        //testResultSetMetaData();

        //testPreparedStatement();

        //testBatchProcessing();
        //testBatchProcessing_usePreparedStatement();
    }

    private static void JdbcCommitTest() {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/eBookStore?" +
                                "&serverTimezone=UTC" +
                                "&allowPublicKeyRetrieval=true" +
                                "&useSSl=false",
                        "root",
                        ""
                );

                Statement statement = connection.createStatement();
        ) {
            // Disable auto-commit
            connection.setAutoCommit(false);

            //Trước khi thay đổi:
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Book WHERE IDBook = 1");
            System.out.println("Trước khi thay đổi: ");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("IDBook") + ", " +
                        resultSet.getString("Name") + ", " +
                        resultSet.getString("Qty"));
            }
            connection.commit();

            //Thay đổi data lần 1:
            statement.executeUpdate("UPDATE Book Set Qty = 200 WHERE IDBook = 1");
            connection.commit();

            resultSet = statement.executeQuery("SELECT * FROM Book WHERE IDBook = 1");
            System.out.println("Sau khi thay đổi Qty = 200 và Commit: ");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("IDBook") + ", " +
                        resultSet.getString("Name") + ", " +
                        resultSet.getString("Qty"));
            }

            //Thay đổi data lần 2:
            statement.executeUpdate("UPDATE Book Set Qty = 500 WHERE IDBook = 1");
            connection.rollback();

            resultSet = statement.executeQuery("SELECT * FROM Book WHERE IDBook = 1");
            System.out.println("Sau khi thay đổi Qty = 500 và Rollback: ");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("IDBook") + ", " +
                        resultSet.getString("Name") + ", " +
                        resultSet.getString("Qty"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void JdbcCommitCatchTest() {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/eBookStore?" +
                                "&serverTimezone=UTC" +
                                "&allowPublicKeyRetrieval=true" +
                                "&useSSl=false",
                        "root",
                        ""
                );

                Statement statement = connection.createStatement();
        ) {
            try {
                connection.setAutoCommit(false);
                statement.executeUpdate("INSERT INTO Book (IDBook, IDCategory, IDAuthor, IDPublishCompany, Name, Price, Qty) VALUES (1000, 1, 1, 1, 'Hieu', 650000, 656);");
                statement.executeUpdate("INSERT INTO Book (IDBook, IDCategory, IDAuthor, IDPublishCompany, Name, Price, Qty) VALUES (1000, 1, 1, 1, 'Hieu', 650000, 656);");
                connection.commit();
            } catch (SQLException exception) {
                System.out.println("Có lỗi xảy ra, dữ liệu sẽ được RollBack");
                connection.rollback();
                exception.printStackTrace();
            }
        } catch (SQLException ignored) {
            //ignored
            ignored.printStackTrace();
        }
    }

    private static void testResultSetMetaData() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/eBookStore?" +
                            "&serverTimezone=UTC" +
                            "&allowPublicKeyRetrieval=true" +
                            "&useSSL=false",
                    "root",
                    ""
            );

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Book;");

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            int columnCount = resultSetMetaData.getColumnCount();

            for (int i = 1; i <= columnCount; ++i) {
                System.out.printf("%-30s", resultSetMetaData.getColumnName(i));
            }
            System.out.println(); //New line

            for (int i = 1; i <= columnCount; ++i) {
                System.out.printf("%-30s", "(" + resultSetMetaData.getColumnClassName(i) + ")");
            }
            System.out.println(); //New line

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; ++i) {
                    System.out.printf("%-30s", resultSet.getString(i));
                }
                System.out.println(); //New line
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void testPreparedStatement() {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/eBookStore?" +
                                "&serverTimezone=UTC" +
                                "&allowPublicKeyRetrieval=true" +
                                "&useSSL=false",
                        "root",
                        ""
                );

                PreparedStatement preparedStatement_insert = connection.prepareStatement(
                        "INSERT INTO Book (IDCategory, IDAuthor, IDPublishCompany, Name, Price, Qty) " +
                                "VALUES (?, ?, ?, ?, ?, ?);");
                PreparedStatement preparedStatement_select = connection.prepareStatement("SELECT * FROM Book;");
        ) {
            preparedStatement_insert.setInt(1, 1); //IDCategory
            preparedStatement_insert.setInt(2, 1); //IDAuthor
            preparedStatement_insert.setInt(3, 1); //IDPublishCompany
            preparedStatement_insert.setString(4, "Hieu-testPreparedStatement"); //Name
            preparedStatement_insert.setDouble(5, 99000); //Price
            preparedStatement_insert.setInt(6, 566); //Qty

            int countRecordAffected = preparedStatement_insert.executeUpdate();
            System.out.println("Part 1 - Number of record affected: " + countRecordAffected);

            preparedStatement_insert.setInt(1, 5); //IDCategory
            preparedStatement_insert.setInt(2, 6); //IDAuthor
            countRecordAffected = preparedStatement_insert.executeUpdate();
            System.out.println("Part 2 - Number of record affected: " + countRecordAffected);

            ResultSet resultSet = preparedStatement_select.executeQuery();
            while (resultSet.next()) {
                System.out.println(
                        String.format("%-5s %-5s %-5s %-5s %-82s %-10s %-5s %-12s %-280s %-12s %-12s %-8s %-8s %-5s",
                                resultSet.getInt("IDBook"),
                                resultSet.getInt("IDAuthor"),
                                resultSet.getInt("IDCategory"),
                                resultSet.getInt("IDPublishCompany"),
                                resultSet.getString("Name"),
                                resultSet.getDouble("Price"),
                                resultSet.getInt("Qty"),
                                resultSet.getString("DatePublish"),
                                resultSet.getString("Description"),
                                resultSet.getString("CreatedBy"),
                                resultSet.getString("UpdatedBy"),
                                resultSet.getString("CreatedDate"),
                                resultSet.getString("UpdatedDate"),
                                resultSet.getString("Enabled")));
            }

            preparedStatement_insert.clearParameters(); //Xoá tất cả Parameters
            preparedStatement_select.clearParameters(); //Xoá tất cả Parameters (k có Parameters nào để xoá)
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void testBatchProcessing() {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/eBookStore?" +
                                "&serverTimezone=UTC" +
                                "&allowPublicKeyRetrieval=true" +
                                "&useSSL=false",
                        "root",
                        ""
                );

                Statement statement = connection.createStatement();
        ) {
            connection.setAutoCommit(false);

            statement.addBatch("INSERT INTO Book (IDCategory, IDAuthor, IDPublishCompany, Name, Price, Qty) VALUES (1, 1, 1, 'Hieu-testBatchProcessing-1', 650000, 656);");
            statement.addBatch("INSERT INTO Book (IDCategory, IDAuthor, IDPublishCompany, Name, Price, Qty) VALUES (1, 1, 1, 'Hieu-testBatchProcessing-2', 650000, 656);");
            statement.addBatch("INSERT INTO Book (IDCategory, IDAuthor, IDPublishCompany, Name, Price, Qty) VALUES (1, 1, 1, 'Hieu-testBatchProcessing-3', 650000, 656);");

            int[] returnCodes = statement.executeBatch();

            System.out.println("Return codes are: ");
            for (var item : returnCodes) {
                System.out.print(item + ", ");
            }
            System.out.println(); //New line;
            connection.commit();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void testBatchProcessing_usePreparedStatement() {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/eBookStore?" +
                                "&serverTimezone=UTC" +
                                "&allowPublicKeyRetrieval=true" +
                                "&useSSL=false",
                        "root",
                        ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO Book (IDCategory, IDAuthor, IDPublishCompany, Name, Price, Qty) " +
                                "VALUES (?, ?, ?, ?, ?, ?);");
        ) {
            connection.setAutoCommit(false);

            preparedStatement.setInt(1, 1); //IDCategory
            preparedStatement.setInt(2, 1); //IDAuthor
            preparedStatement.setInt(3, 1); //IDPublishCompany
            preparedStatement.setString(4, "Hieu-testBatchProcessing_usePreparedStatement"); //Name
            preparedStatement.setDouble(5, 99000); //Price
            preparedStatement.setInt(6, 566); //Qty

            preparedStatement.addBatch();

            preparedStatement.setInt(1, 5); //IDCategory
            preparedStatement.setInt(2, 6); //IDAuthor

            preparedStatement.addBatch();

            int[] returnCodes = preparedStatement.executeBatch();

            System.out.println("Return codes: ");
            for (var item : returnCodes) {
                System.out.print(item + ", ");
            }
            System.out.println(); //New line

            connection.commit();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
