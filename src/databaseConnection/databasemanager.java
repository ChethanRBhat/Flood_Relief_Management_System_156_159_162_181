/*package databaseConnection;

public class databasemanager {
*/    
/*

public String getFromDB(String table, String cond, String val, String fetch) {
    String query = "SELECT " + fetch + " FROM " + table + " WHERE " + cond + " = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, val);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString(fetch);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle or log the exception as needed
    }
    return null;
}

public String get_from_db(String table,String cond,String val,String fetch){
    query="SELECT" + fetch+"FROM"+ table +"WHERE"+cond+"="+val+";";
    ExecuteDBQ exec=new ExecuteDBQ();
    result = exec.fetch_execute(query,fetch);
    return result;
}

public String[] fetch_all(String table,int n){
    query="SELECT * FROM"+ table +";";
    query.tostring();
    ExecuteDBQ exec=new ExecuteDBQ();
    arr_res = exec.fetch_execute(query,n);
    return arr_res;
}

public String[] fetchAll(String table) {
    List<String> results = new ArrayList<>();
    String query = "SELECT * FROM " + table;
    try (Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {
        while (resultSet.next()) {
            // Adjust this according to your table structure
            String data = resultSet.getString(1); // Assuming you're fetching the first column
            results.add(data);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle or log the exception as needed
    }
    return results.toArray(new String[0]);
}
}
*/