package web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.AbstractComponents.AbstractComponent;
import web.constants.PageConstants;

import java.util.ArrayList;
import java.util.List;

public class PostDetails extends AbstractComponent {

    /**
     * this is the webDriver through which we can run the tests
     */
    WebDriver driver;

    /**
     * this is the textbox through which we will input the comment
     */
    @FindBy(xpath = "//div[@data-placeholder='What are your thought?']")
    WebElement commentTextBox;

    /**
     * this is the button to press when making a comment
     */
    @FindBy(xpath = "//button[@type='submit']")
    WebElement commentButton;

    /**
     * these is the comment text in the post comments
     */
    @FindBy(id = PageConstants.NULL_LOCATOR)
    By comment;

    /**
     * these are people who made comments on a post
     */
    @FindBy(xpath = ".//div[1]/div/div[2]/div[1]/div[2]/div/div[2]")
    List<WebElement> commentPeople;

    /**
     * this is the username
     */
    By userName = By.tagName("a");

    /**
     * this is the user upvote button
     */
    By commentUpVote = By.xpath("(.//*[local-name()='svg'])[1]");

    /**
     * this is the user downvote button
     */
    By commentDownVote = By.xpath("(.//*[local-name()='svg'])[2]");

    /**
     * this is the insight button
     */
    @FindBy(xpath = "//span[.='Insights']/..")
    WebElement inSightsButton;

    /**
     * these are the list of the replies
     */
    By repliesLocator  = By.xpath(".//div[@class='MuiBox-root css-wjeivw']");

    /**
     * these are the comments text
     */
    By commentText = By.xpath(".//p/div/p");

    /**
     * this is the button to share a post
     */
    @FindBy(xpath = "(//span[text()='Share'])[1]")
    WebElement shareButton;

    /**
     * this is sharing using copying the link
     */
    @FindBy(xpath = "//div[@class='MuiBox-root css-1rru4r9']")
    WebElement SharedWithPlaces;

    /**
     * this is the link to my profile text in the share
     */
    @FindBy(xpath = "/html/body/div/div/div/div[1]/form/div[2]/div/div[2]/ul[1]/li")
    WebElement myProfileShare;

    /**
     * this is the share button
     */
    @FindBy(xpath = "//button[text()='post']")
    WebElement shareButtonInSharePage;

    /**
     * this is the my profile icon in the bar
     */
    @FindBy(xpath = "/html/body/div/header/div/div[2]/ul/div/div")
    WebElement myIconInTheBar;

    /**
     * this is the my profile icon in the drop down menu
     */
    @FindBy(xpath = "//*[text()='profile']")
    WebElement profileIconInTheDropDown;

    /**
     * this is the identifier of the profile page
     */
    @FindBy(xpath = "//*[text()='NEW! Now you can get data and insights on your posts']")
    WebElement profileIdentifier;

    /**
     * this is the list of posts content in my profile
     */
    @FindBy(xpath = "//div[@data-testid='post-body']")
    List<WebElement> postsText;

    /**
     * this is the button that's used to upvote the current post
     */
    @FindBy(xpath = "(//*[@data-testid='ForwardOutlinedIcon'])")
    List<WebElement> votePostBtn;

    /**
     * these are list of the selected voted buttons
     */
    @FindBy(xpath = "(//*[@data-testid='ForwardIcon'])")
    WebElement selectedVoteBtn;

    /**
     * this is the list of buttons that's used to downvote a specific comment
     */
    @FindBy(id = PageConstants.NULL_LOCATOR)
    By downVotesCommentsBtn;

    /**
     * this is the list of buttons that's used to upvote a specific comment
     */
    @FindBy(id = PageConstants.NULL_LOCATOR)
    By upVotesCommentsBtn;

    /**
     * this is the difference between number of upvotes and downvote text
     */
    @FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-caption css-sfqsx-MuiTypography-root']")
    WebElement numOfVotesText;

    /**
     * this is the text that holds the number of upvotes for a specific comment
     */
    @FindBy(id = PageConstants.NULL_LOCATOR)
    By upVotesCommentText;

    /**
     * this is the number of votes on this post
     */
    By numOfVotes = By.xpath("//div[@class='MuiBox-root css-1py4uq7']");

    /**
     * this is the text that holds the number of downvotes for a specific comment
     */
    @FindBy(id = PageConstants.NULL_LOCATOR)
    By downVotesCommentText;

    /**
     * this is the button that we will have to click when we want to reply to someone
     */
    By replyButton = By.xpath(".//span[text()='Reply']");

    /**
     * this is the text input through which we will write our reply to someone
     */
    By replyTextInput = By.xpath(".//div[@class='ql-editor ql-blank']");

    /**
     * this is the button through which we will post our reply
     */
    By replyTextButton = By.xpath(".//button[text()='Reply']");

    /**
     * this is the current post body text
     */
    @FindBy(xpath = "//div[@data-testid='post-body']/p")
    WebElement postText;

    /**
     * this is the current number of the views
     */
    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-1mvaz11-MuiTypography-root'])[1]")
    WebElement currentNumOfView;

    /**
     * this is the current number of total shares
     */
    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-1mvaz11-MuiTypography-root'])[2]")
    WebElement currentNumOfShares;

    /**
     * this is the current number of total comments
     */
    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-1mvaz11-MuiTypography-root'])[3]")
    WebElement currentNumOfComments;


    /**
     * this is the constructor of the class and it initializes all of its members using PageFactory class
     *
     * @param driver : which is generated by selenium testcase
     */
    public PostDetails(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * this method is used to get the string content of a post
     * @return String: which is the content of the current post
     */
    public String getCurrentPostContent(){
        return postText.getText();
    }

    /**
     * this method is used to get the current number of views
     */
    public int getCurrentNumberOfView(){
        return Integer.parseInt(currentNumOfView.getText());
    }

    /**
     * this method is used to get the current number of comments
     */
    public int getCurrentNumberOfComments(){
        return Integer.parseInt(currentNumOfComments.getText());
    }

    /**
     * this method is used to get the current number of shares
     */
    public int getCurrentNumberOfShares(){
        return Integer.parseInt(currentNumOfShares.getText());
    }

    /**
     * this method is used to make a comment
     * @param comment: this is the string to be inserted as a comment
     */
    public void makeComment(String comment){
        //waitForWebElementToAppear(commentButton,5);
        threadSleep(2);
        commentTextBox.sendKeys(comment);
        commentButton.click();
        threadSleep(2);
    }

    /**
     * this method is used to reply to a random user on some random post
     * @param comment: this is the comment that we will reply as a reply
     * @param userNameIndex: this is the index of user whom we will reply to
     */
    public void replyToComment(String comment, int userNameIndex){
        commentPeople.get(userNameIndex).findElement(replyButton).click();
        commentPeople.get(userNameIndex).findElement(replyTextInput).sendKeys(comment);
        commentPeople.get(userNameIndex).findElement(replyTextButton).click();
        threadSleep(2);
        driver.navigate().refresh();
    }

    /**
     * this method gets the comment made by a specific user
     * @param userName: this is the name of the user who made this comment
     * @return String: the comment made by the user given as input
     */
    public List<String> getCommentOfUser(String userName){
        List<String> commentsText = new ArrayList<>();
        for (WebElement element : commentPeople){
            if(element.findElement(By.xpath(".//a")) != null && element.findElement(By.xpath(".//a")).getText().equalsIgnoreCase(userName))
                commentsText.add(element.findElement(commentText).getText());
        }
        return commentsText;
    }

    /**
     * this methods returns all the reply text to a comment
     * @param commentIndex : the index of the comment
     * @return List<String> : the replys
     */
    public List<String> getRepliesToAComment(String myUserName, int commentIndex){
        WebElement comment = commentPeople.get(commentIndex);
        List<String> repliesText = new ArrayList<>();
        List<WebElement> repliesCard = comment.findElements(repliesLocator);
        for (WebElement element : repliesCard){
            if(element.findElement(By.xpath(".//a")) != null && element.findElement(By.xpath(".//a")).getText().equalsIgnoreCase(myUserName))
                repliesText.add(element.findElement(commentText).getText());
        }
        return repliesText;
    }

    /**
     * this function is to share a link and get that link
     * @return List<String>: all text contents of a posts in my profiles
     */
    public List<String> sharePostToMyProfile(){
        List<String> sharedPosts = new ArrayList<>();
        shareButton.click();
        waitForWebElementToAppear(SharedWithPlaces, 1);
        SharedWithPlaces.click();
        waitForWebElementToAppear(myProfileShare, 1);
        myProfileShare.click();
        shareButtonInSharePage.click();
        threadSleep(2);
        driver.switchTo().alert().accept();
        myIconInTheBar.click();
        waitForWebElementToAppear(profileIconInTheDropDown, 2);
        profileIconInTheDropDown.click();
        threadSleep(3);
        waitForWebElementToAppear(profileIdentifier, 4);
        for(WebElement element : postsText){
            sharedPosts.add(element.getText());
        }
        return sharedPosts;
        /*try {
            return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); // extracting the text that was copied to the clipboard
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }*/
    }

    /**
     * this function returns the name of someone at specific position in the comments section
     * @param index: this is the index that we want the name of user at
     * @return String: the name of the username at the given index
     */
    public String getUserNameOfIndex(int index){
        return commentPeople.get(index).findElement(userName).getText();
    }

    /**
     * this function is used to upvote a post
     */
    public void upVotePost(){
        votePostBtn.get(0).click();
        driver.navigate().refresh();
        threadSleep(1);
    }

    /**
     * this function is used to downvote a post
     */
    public void downVotePost(){
        votePostBtn.get(1).click();
        driver.navigate().refresh();
        threadSleep(1);
    }

    /**
     * this function is used to downvote a comment
     */
    public void downVoteComment(int userIndex){
        commentPeople.get(userIndex).findElement(commentDownVote).click();
        driver.navigate().refresh();
    }

    /**
     * this function is used to upvote a comment
     */
    public void upVoteComment(int userIndex){
        commentPeople.get(userIndex).findElement(commentUpVote).click();
        driver.navigate().refresh();
    }

    /**
     * this methods the number of votes on a post
     * @return int: the number of votes on a post
     */
    public int getNumOfVotesPostBefore(){
        if(selectedVoteBtn != null && selectedVoteBtn.isDisplayed())
            selectedVoteBtn.click();
        threadSleep(1);
        return Integer.parseInt(numOfVotesText.getText());
    }


    public int getNumOfVotesPostAfter(){
        return Integer.parseInt(numOfVotesText.getText());
    }

    /**
     * this methods the number of upvotes on a comment
     * @return int: the number of upvotes on a comment
     */
    public int getNumOfVotesComment(int userIndex){
        return Integer.parseInt(commentPeople.get(userIndex).findElement(numOfVotes).getText());
    }

    /**
     * this method is used to test the insights button
     */
    public void clickOnInSightsButton(){
        inSightsButton.click();
    }

}
