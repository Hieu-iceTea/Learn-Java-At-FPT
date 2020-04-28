package AdvancedLearning;

import CodeLean.Java2_06.GiftShop.GiftModel.Gift;
import MyUtilities.Utility;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        //AdvancedLearning.LearnReflection.Run.main(args);

        test_executeQuery_useMetaDataAndReflection();
    }

    private static void test_executeQuery_useMetaDataAndReflection() {
        //IDBook, IDAuthor, IDCategory, IDPublishCompany, Name, Price, Qty, DatePublish, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled


        List<Object> lstGift = Utility.executeQuery(
                "eBookStore",
                "SELECT * FROM Book;",
                Gift.class.getName());


        for (var item : lstGift) {
            System.out.println(item);
        }
    }
}
