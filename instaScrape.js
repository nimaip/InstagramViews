//List of all views on curr page
let x = document.getElementsByClassName('_aacl _aacp _aacw _aad3 _aad6');
var list = new Array();
for(let i = 0; i < x.length; i++){
    let num = x[i].innerHTML.indexOf('/');
    if((i+1)%3 == 0)
    list.push(x[i].innerHTML.substring(6, num-1));
}
console.log(list);

//List of #'s when reel is opened
let s = document.getElementsByClassName("_aacl _aaco _aacu _aacx _aad7 _aade")[0].innerHTML;
let n = s.substring(s.indexOf("#"));
const set = new Set();
while(n.indexOf("#")>=0){
let word = n.substring(n, n.indexOf("<"));
    if(word.length > 0)
set.add(word);
n = n.substring(n.indexOf("#") + n.substring(n, n.indexOf("<")).length);
}
console.log(set);

//Function to simulate clicking on a reel
