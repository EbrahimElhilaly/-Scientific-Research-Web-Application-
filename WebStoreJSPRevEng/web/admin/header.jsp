  <div align="center">
            <img src="<%=request.getContextPath()%>/resources/images/Logo Library.png" alt=""
                 width="300px" height="150px" />
        </div>

        <div align="center">
            Welcome admin | <%= session.getAttribute("USERNAME") %> <a href="login?ac=logout">Logout</a>
        </div>

        <div align="center">
            <b>
                 <a href="<%=request.getContextPath()%>/admin">Home</a>|
                <a href="l-u">Users</a>|
                <a href="l-c">Categories</a>|
                <a href="l-b">Books</a>|
                <a href="">Customers</a>|
                <a href="">Reviews</a>|
                <a href="">Orders</a>|

            </b>
        </div>
                
                
