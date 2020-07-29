package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class Friend {

    private String name;
    private int commonFriends;

    public Friend(WebElement element){
       this.name = element.findElement(By.className("android.widget.TextView")).getText();
       this.commonFriends = element.getAttribute("content-desc").replaceAll("\\D+","").equals("") ? 0 :
               Integer.parseInt(element.getAttribute("content-desc").replaceAll("\\D+",""));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof objects.Friend)) return false;
        objects.Friend friend = (objects.Friend) o;
        return commonFriends == friend.commonFriends &&
                name.equals(friend.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, commonFriends);
    }
}
