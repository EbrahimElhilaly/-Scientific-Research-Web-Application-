/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// doaa //
var grDate, grMonth , grYear, fullGrgDate,
       grDate2, grMonth2 , grYear2, fullGrgDate2 ;

 var pickedTxt = $('input[title="picked-text-gr"]'),
       // pickBtn = $('input[title="pick-button-gr"]'),
        pickBtn = document.getElementById('pick-button-gr'),
        datepicker = new Calendar(),
        
        pickedTxt2 = $('input[title="picked-text-gr2"]'),
       // pickBtn = $('input[title="pick-button-gr"]'),
        pickBtn2 = document.getElementById('pick-button-gr2'),
        datepicker2 = new Calendar();


    document.getElementById('datepicker-gr').appendChild(datepicker.getElement());
    datepicker.getElement().style.marginTop = '10px';
    
document.getElementById('datepicker-gr2').appendChild(datepicker2.getElement());
    datepicker2.getElement().style.marginTop = '10px';

    datepicker.callback = function() {
                
        //pickedTxt.value = datepicker.getDate().getDateString();
        
        // doaa : set gregorian date to input text //
        
        //fullGrgDate = datepicker.getDate().getDateString();
        grDate = datepicker.getDate().getDate();
        grMonth = datepicker.getDate().getMonth()+1;
        grYear = datepicker.getDate().getFullYear();
        fullGrgDate = grYear + "-" + grMonth + "-" + grDate;
        
        pickedTxt.val(fullGrgDate);
        
        pickedTxt.selectionStart = 0;
        //pickedTxt.selectionEnd = pickedTxt.value.length;
        pickedTxt.selectionEnd = pickedTxt.val().length;
        pickedTxt.focus();
    };

datepicker2.callback = function() {
                
        //pickedTxt.value = datepicker.getDate().getDateString();
        
        // doaa : set gregorian date to input text //
        
        //fullGrgDate = datepicker.getDate().getDateString();
        grDate2 = datepicker2.getDate().getDate();
        grMonth2 = datepicker2.getDate().getMonth()+1;
        grYear2 = datepicker2.getDate().getFullYear();
        fullGrgDate2 = grYear2 + "-" + grMonth2 + "-" + grDate2;
        
        pickedTxt2.val(fullGrgDate2);
        
        pickedTxt2.selectionStart = 0;
        //pickedTxt.selectionEnd = pickedTxt.value.length;
        pickedTxt2.selectionEnd = pickedTxt2.val().length;
        pickedTxt2.focus();
    };
    datepicker.onHide = function() {
        
        pickBtn.style.display = 'inline-block';
        
         pickBtn2.style.display = 'inline-block';
        
        //$('input[title="pick-button-gr"]').attr("style","display:inline-block");
        // $('input[title="pick-button-gr"]').css("display", "inline-block");
    };

    function pickADate() {
        
       pickBtn.style.display = 'none';
       
      //  $('input[title="pick-button-gr"]').css("display", "none");
      // $('input[title="pick-button-gr"]').attr("style","display:none");
        
        datepicker.show();
    }
    
    function pickADate2() {
        
       pickBtn2.style.display = 'none';
       
      //  $('input[title="pick-button-gr"]').css("display", "none");
      // $('input[title="pick-button-gr"]').attr("style","display:none");
        
        datepicker2.show();
    }

