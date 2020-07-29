package pages.android;

import objects.Friend;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AllFriedsPage extends Page {

    private org.openqa.selenium.By friendsList1 = (org.openqa.selenium.By.xpath("//android.view.ViewGroup[contains(@resource-id,'(name removed)')]/android.widget.TextView/.."));

    public int countingAllFriends() {
        Set<Friend> names = new HashSet<>();
        Set<Friend> newName = new HashSet<>();

        while (names.isEmpty() | !names.containsAll(newName)) {
            names.addAll(newName);
            List<WebElement> elem = driver.findElements(friendsList1);
            newName = elem.stream().map(i ->  new Friend(i)).collect(Collectors.toSet());
            swiptToBottom();
        }
        return names.size();
    }

    public void checkCount(int expectedCount){
        org.testng.Assert.assertEquals(expectedCount, countingAllFriends(), "Mobile shows wrong count of friends");
    }

}
