  const tabList = document.querySelectorAll('.tab_menu .list li');
  
    tabList.querySelector('.btn').addEventListener('click', function() {
       	tabList[0].classList.remove('selected');
       	tabList[0].classList.replace('selected', 'is_off');
        //this.parentNode.classList.add('selected');
        
      // tabList[j].classList.remove('selected');
    });
    
    // element.classList.replace('변경전이름', '변경후이름');