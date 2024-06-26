### DỰ ÁN PHẦM MỀM BÁN TÚI XÁCH NỮ DA VELISA
```
“Phần mềm bán túi xách da nữ Velisa”: là phần mềm giúp các cơ sở kinh doanh nhỏ lẻ túi xách có thể quản lý lượng sản phẩm khổng lồ từ nhu cầu người dùng cũng như tối ưu hóa lợi nhuận bán hàng trên thị trường ,  nâng cao chất lượng dịch vụ và trải nghiệm người dùng. 
```
### Library use
- flatlaf-3.2.jar
- flatlaf-extras-3.2.jar
- jsvg-1.2.0.jar
- flatlaf-fonts-roboto-2.137.jar
- swing-toast-notifications-1.0.1.jar

### Sample code to show form
``` java
Application.showForm(new PanelForm());
Application.setSelectedMenu(0, 0);
```
### Menu Items
``` java

private final String menuItems[][] = {
    {"~MAIN~"},
    {"Dashboard"},
    {"Email", "Inbox", "Read", "Compost"},
};
```
### Menu Event
``` java
menu.addMenuEvent(new MenuEvent() {
    @Override
    public void menuSelected(int index, int subIndex, MenuAction action) {
        if (index == 1) {
            if (subIndex == 1) {
                Application.showForm(new FormInbox());
            } else if (subIndex == 2) {
                Application.showForm(new FormRead());
            }
        } else {
            action.cancel();
        }
    }
});
```
