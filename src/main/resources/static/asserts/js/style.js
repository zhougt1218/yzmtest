$(function(){
	f();	//字母验证码
	fnum();	//算术题验证码
	ftxt();	//汉字验证码
});

$("#myCanvas").click(function(){
	f();
});
$("#myCanvas1").click(function(){
	fnum();
});
$("#myCanvas2").click(function(){
	ftxt();
});
/*Canvas字母验证码*/
function f(){
	debugger
	var c=document.getElementById("myCanvas");
	var ctx=c.getContext("2d");
	ctx.font="20px Verdana";
	ctx.clearRect(0,0,c.width,c.height);
	var gradient=ctx.createLinearGradient(0,0,c.width,0);
	gradient.addColorStop("0","magenta");
	gradient.addColorStop("0.5","blue");
	gradient.addColorStop("1.0","red");
	ctx.beginPath();
    //定义直线的起点坐标为(10,10)
	var t=Math.random()*10;
	var t1=Math.random()*100;
	var t2=Math.random()*10;
    ctx.moveTo(t, t1);
    ctx.lineTo(t1, t2);
    ctx.lineTo(t2, t);
    //定义直线的终点坐标为(50,10)
    ctx.lineTo(50, 10);
    //沿着坐标点顺序的路径绘制直线
    ctx.strokeStyle = "blue"; 
    ctx.stroke();
    //关闭当前的绘制路径
    ctx.closePath();
	//把渐变色添加到画布
	ctx.fillStyle=gradient;
	$.get("yzm.action",null,function(k){
		ctx.fillText(k,10,22);
	})
}
$("#yz1").click(function(){
	var textyzm=$("#cvyzm").val();
	$.get("login.action",{"yzm":textyzm},function(k){
		alert(k);
	})
});

/*算数式子验证码*/
function fnum(){
	//alert("ttt");
	var c=document.getElementById("myCanvas1");
	var ctx=c.getContext("2d");
	ctx.font="14px Verdana";
	ctx.clearRect(0,0,c.width,c.height);
	var gradient=ctx.createLinearGradient(0,0,c.width,0);
	gradient.addColorStop("0","magenta");
	gradient.addColorStop("0.5","blue");
	gradient.addColorStop("1.0","red");
	ctx.beginPath();
    //定义直线的起点坐标为(10,10)
	var t=Math.random()*10;
	var t1=Math.random()*100;
	var t2=Math.random()*10;
    ctx.moveTo(t, t1);
    ctx.lineTo(t1, t2);
    ctx.lineTo(t2, t);
    //定义直线的终点坐标为(50,10)
    ctx.lineTo(50, 10);
    //沿着坐标点顺序的路径绘制直线
    ctx.strokeStyle = "blue"; 
    ctx.stroke();
    //关闭当前的绘制路径
    ctx.closePath();
	
	//把渐变色添加到画布	ctx.fillStyle=gradient;
	ctx.fillStyle=gradient;
	$.get("numyzm.action",null,function(k){
		//alert(k);
		ctx.fillText(k,10,22);
	})
}
$("#yz2").click(function(){
	//alert("1111111111111")
	var numyzm=$("#numyzm").val();
	if(numyzm==""){
		alert("false");
	}else{
		$.get("login1.action",{"numyzm":numyzm},function(k){
			alert(k);
		})
	}
});


/*汉字验证码*/
function ftxt(){
	var c=document.getElementById("myCanvas2");
	var ctx=c.getContext("2d");
	
	ctx.font="16px Verdana";
	ctx.clearRect(0,0,c.width,c.height);
	var gradient=ctx.createLinearGradient(0,0,c.width,0);
	gradient.addColorStop("0","magenta");
	gradient.addColorStop("0.5","blue");
	gradient.addColorStop("1.0","red");
	ctx.beginPath();
    //定义直线的起点坐标为(10,10)
	var t=Math.random()*10;
	var t1=Math.random()*100;
	var t2=Math.random()*10;
    ctx.moveTo(t, t1);
    ctx.lineTo(t1, t2);
    ctx.lineTo(t2, t);
    //定义直线的终点坐标为(50,10)
    ctx.lineTo(50, 10);
    //沿着坐标点顺序的路径绘制直线
    ctx.strokeStyle = "blue"; 
    ctx.stroke();
    //关闭当前的绘制路径
    ctx.closePath();
	//把渐变色添加到画布
	ctx.fillStyle=gradient;
	$.get("txtyzm.action",null,function(k){
		ctx.fillText(k,10,22);
	})
}
$("#yz3").click(function(){
	var textyzm=$("#txtyzm").val();
	$.get("login2.action",{"textyzm":encodeURI(textyzm)},function(k){
		alert(k);
	})
});