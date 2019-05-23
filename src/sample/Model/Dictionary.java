package sample.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dictionary {
    private int dictionaryId;
    private DatabaseManager dbm;

    // Constructor
    public Dictionary(String dictionaryName) {
        this.dbm = new DatabaseManager();
        String sql = "SELECT id FROM Dictionary WHERE name = ?";
        try (Connection conn = this.dbm.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dictionaryName);
            ResultSet resultSet = pstmt.executeQuery();
            this.dictionaryId = resultSet.getInt("id");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Word search(String word) {
        return this.dbm.getWord(this.dictionaryId, word);
    }

    public void insertWord(String word, String mean) {
        this.dbm.insertWord(this.dictionaryId, word, mean);
    }

    public void updateWord(String word, String newWord) {
        this.dbm.updateWord(this.dictionaryId, word, newWord);
    }

    public void updateMean(String word, String mean) {
        this.dbm.updateMean(this.dictionaryId, word, mean);
    }

    public void deleteWord(String word) {
        this.dbm.deleteWord(this.dictionaryId, word);
    }
}