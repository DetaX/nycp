$(document).ready(function(){
    if($("#jurisdiction").val() === "new"){
         $("#newJurisdiction").css("display","inline");
     }
     if($("#motive").val() === "new"){
         $("#newMotive").css("display","inline");
     }
    
    $("#jurisdiction").change(function(){
     if($("#jurisdiction").val() === "new"){
         $("#newJurisdiction").css("display","inline");
     }
     else{
         $("#newJurisdiction").css("display","none");
         $("#newJurisdiction").val("");
     }
    });
    $("#motive").change(function(){
     if($("#motive").val() === "new"){
         $("#newMotive").css("display","inline");
     }
     else{
         $("#newMotive").css("display","none");
         $("#newMotive").val("");
     }
    });
});





