import org.testng.Assert;
import org.testng.annotations.Test;



public class FakerApiTests extends TestRunHelper {

    @Test
    public void isQuantityEqual() {
        int quantity = 2;
        int totalNumber = checkQuantity.getTotalNumber(200,quantity)[0];
        int dataSize = checkQuantity.getTotalNumber(200,quantity)[1];
        Assert.assertEquals(totalNumber,quantity);
        Assert.assertEquals(dataSize,quantity);
    }

    @Test
    public void isCharacterCountEqualToZero() {
        int characterSize = characterCount.checkCharacterSize(200,0);
        Assert.assertEquals(characterSize,0);
        // 0 girsek dahi 200e yakın bir değer veriyor
    }

    @Test
    public void isCharacterCountEqualToTwoHundred() {
        int characterSize = characterCount.checkCharacterSize(200,200);
        Assert.assertEquals(characterSize,200);
        // 200 girsek dahi genelde 3,4 eksiğini veriyor
    }

    @Test
    public void isCharacterCountEqualToFiveHundred() {
        int characterSize = characterCount.checkCharacterSize(200,500);
        Assert.assertEquals(characterSize,500);
        // 500 girsek dahi genelde 3,4 eksiğini veriyor
    }

    @Test
    public void isFieldExist() {
        String[] s = checkFields.getFields(200);
        for(int i=0;i<s.length; i++){
            Assert.assertNotNull(s[i]);
            System.out.println(s[i]);
        }
    }

    @Test
    public void isBodyExist() {
        String[] s = checkBody.getFields(200);
        for(int i=0;i<s.length; i++){
            Assert.assertNotNull(s[i]);
        }
    }
}
