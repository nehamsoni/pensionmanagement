<!DOCTYPE html>
<html>
    <head>
        <title>WELCOME TO DASHBOARD</title>
<style>
            *{
    margin: 0;
    padding: 0;
    font-family: Century Gothic;
}
header{
    background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)) ,url(img/bg.jpg);
    height: 100vh;
    background-size: cover;
    background-position: center;
}
ul{
    float: right;
    list-style-type: none;
    margin-top: 25px;
}
ul li{
    display: inline-block;
}
ul li a{
    text-decoration: none;
    color: #ffffff;
    padding: 5px 20px;
    border : 1px solid transparent;
    transition: 0.6s ease;
}
ul li a:hover{
    background-color: #ffffff;
    color: black;

}
ul li.active a{
    background-color: #ffffff;
    color: black;


}
.logo img{
    float: left;
    width: 150px;
    height: auto;
}
.main{
    max-width: 1200px;
    margin: auto;
}
.title{
    position: absolute;
    top:50%;
    left: 50%;
    transform: translate(-50%,-50%);
}
.title h1{
    color: #ffffff;
    font-size: 60px;
}
.button{
    position: absolute;
    top:62%;
    left: 50%;
    transform: translate(-50%,-50%);
}
.btn{
    border : 1px solid #ffffff;
    padding: 10px 30px;
    transition: 0.6s ease;
    color: #ffffff;
    text-decoration: none;

}

.btn:hover{
    background-color: #ffffff;
    color: black;
}

</style>

</head>
    <body>
        <header>
            <div class="main">
                
                <ul>
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </div>
            <div class="title">
                <h1>WELCOME TO DASHBOARD</h1>
            </div>
            <div class="button">
                <a href="add" class="btn">ADD DETAILS </a>
                <a href="update" class="btn">UPDATE DETAILS</a>
                 <a href="pensionerform" class="btn">PROCEED WITH EXISTING DETAILS</a>
            </div>
        </header>
    </body>
</html>