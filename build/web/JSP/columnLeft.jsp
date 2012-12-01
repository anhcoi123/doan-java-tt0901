<%-- 
    Document   : columnLeft
    Created on : Nov 26, 2012, 1:46:51 PM
    Author     : Lucifer
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="column_left">
    <div class="box">
      <div class="top"><img src="./image/category.png" alt="" />Loại sản phẩm</div>
      <div id="category" class="middle">
      <ul>  
      <asp:Repeater ID="LoadLoaiLK" runat="server">
        <ItemTemplate>
            <li>
                <!--<a href="./category.do?&maloailk="MALOAILK"">("TENLOAILK")</a>-->
            </li>
        </ItemTemplate>
        </asp:Repeater>
        </ul>
      </div>
      <div class="bottom">&nbsp;</div>
    </div>
    <div class="box">
      <div class="top"><img src="./image/brands.png" alt="" />Nhà sản xuất</div>
      <div id="category" class="middle">
      <ul>
      <asp:Repeater ID="LoadNhaSX" runat="server">
        <ItemTemplate>
            <li>
                <!--<a href="./manufacturer.aspx?&mansx="MANSX">"TENNSX"</a>-->
            </li>
        </ItemTemplate>
        </asp:Repeater>
        </ul>
      </div>
      <div class="bottom">&nbsp;</div>
    </div>
</div>

