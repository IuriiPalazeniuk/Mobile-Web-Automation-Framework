package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FriendWeb {

    private String name;
    private int commonFriends;
    private String nameSelector = "./div[@class='buofh1pr hv4rvrfc']/div/a/span";
    private String commonFriendsSelector = "./div[@class='buofh1pr hv4rvrfc']";

    public FriendWeb(WebElement element){
       this.name = element.findElement(By.xpath(nameSelector)).getText();
       this.commonFriends = element.findElement(By.xpath(commonFriendsSelector)).getText().replaceAll("\\D+","").equals("") ? 0 :
               Integer.parseInt(element.findElement(By.xpath(commonFriendsSelector)).getText().replaceAll("\\D+",""));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FriendWeb)) return false;
        FriendWeb friendWeb = (FriendWeb) o;
        return commonFriends == friendWeb.commonFriends &&
                name.equals(friendWeb.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, commonFriends);
    }

}
