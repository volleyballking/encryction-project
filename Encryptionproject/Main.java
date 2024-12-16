class Main {
	public String toString() {
		return "Main []";
	}
public static void main(String[] args) {
    (new Main()).init();
  }
void print(Object o){ System.out.println(o);}
void printt(Object o){ System.out.print(o);}

  void init(){
//    String  s = encode("party animals");
//    String p = decode(s);
//    String a = binary("happy");
//    System.out.println(s);
//    System.out.println(p);
//    System.out.print(a);

    char[] sub = new char[20];
    sub[0] = 'h';
    sub[1] = 'e';
    sub[2] = 'l';
    sub[3] = 'o';
    sub[4] = 'u';
    sub[5] = 'a';
    sub[6] = 'w';
    sub[7] = 'c';
    sub[8] = 'k';
    sub[9] = 'j';
    sub[10] = 'H';
    sub[11] = 'E';
    sub[12] = 'L';
    sub[13] = 'O';
    sub[14] = 'U';
    sub[15] = 'A';
    sub[16] = 'W';
    sub[17] = 'C';
    sub[18] = 'K';
    sub[19] = 'J';
    
    char[] sub2 = new char[20];
    sub2[0] = '\u2663';
    sub2[1] = '\u1800';
    sub2[2] = '\u1808';
    sub2[3] = '\u1807';
    sub2[4] = '\u1806';
    sub2[5] = '\u1805';
    sub2[6] = '\u1804';
    sub2[7] = '\u1803';
    sub2[8] = '\u1802';
    sub2[9] = '\u1801';
    sub2[10] = '\u2663';
    sub2[11] = '\u1800';
    sub2[12] = '\u1808';
    sub2[13] = '\u1807';
    sub2[14] = '\u1806';
    sub2[15] = '\u1805';
    sub2[16] = '\u1804';
    sub2[17] = '\u1803';
    sub2[18] = '\u1802';
    sub2[19] = '\u1801';
    

    
     

    
   

    String file = Input.readFile("original.txt");

    
    //encode cipher//
    String encodedMsg = encode(file);
    Input.writeFile("encode1.txt", encodedMsg);

    
   

    //substitution
    String sa = subEncryption("hello", sub, sub2);
    String subMsg = subEncryption(encodedMsg, sub, sub2);
    Input.writeFile("encode2.txt", subMsg);
    


    //binary// 
    //print(binary(file));
    String b = binary(subMsg);
    Input.writeFile("encode3.txt", b);
    
    
    
    
   //decode
    String d = binary(b);
    Input.writeFile("decode1.txt", d);
    String decodedsub = subEncryption(subMsg, sub2, sub);
    Input.writeFile("decode2.txt", decodedsub);
    String decodedMsg = decode(decodedsub);
    Input.writeFile("decode3.txt", decodedMsg);
    
    //test//
//String subMsg2 = subEncryption(encodedMsg, sub, sub2);
    //Input.writeFile("sub&encodetogether.txt", subMsg2);
    //String decodedMsg2 = subEncryption(subMsg2, sub2, sub);
   // Input.writeFile("Decode3.txt", decodedMsg2);
    
  
    
    
    
  }
  

  

  String encode(String txt){
    String bld="";
    int ascii;
    char ch='\0';
    int count = 1;
    for(int x=0; x<=txt.length()-1;x++){
      ch=txt.charAt(x);
      ascii=(int)ch;
      ascii+=count;
      count++;
      if( count > 4){
        count=1;
      }
      bld+= (char)ascii;
    }
    return bld;
  }

  String decode(String txt){
    String bld="";
    int ascii;
    char ch='\0';
    int count = 1;
    for(int x=0; x<=txt.length()-1;x++){
      ch=txt.charAt(x);
      ascii=(int)ch;
      ascii-=count;
      count++;
      if( count > 4){
        count=1;
      }
      bld+= (char)ascii;
    }
    return bld;
  }

  

  String subEncryption(String s, char[] sub, char[] sub2){
    String bld="";
    char ch ='\0';
    int index=0;
    for(int x=0; x<=s.length()-1; x++){
      ch=s.charAt(x);
      index=indexOf(ch,sub);
      if(index!=-1){
        bld+=sub2[index];
      }
      else{
        bld+=ch;
      }
    }
    return bld;
  }


  String binary(String txt){
    String bld="";
    int ascii;
    char ch='\0';
    
    for(int x = 0; x<=txt.length()-1;x++ ){
      ch=txt.charAt(x);
      ascii=(int)ch;
      String bin = Integer.toBinaryString(ch);
      bin = pad(bin);
      bin=comp(bin);
      ascii = Integer.parseInt(bin,2);
      ch=(char)ascii;
      bld+=ch;
     
    }
    return bld;
  }
  String comp(String txt){
    String bld ="";
    for(int x=0; x<=txt.length()-1;x++){
      if(txt.charAt(x) == '1')
        bld+="0";
      else
        bld+="1";
    }
    return bld;
  }

  String pad(String bin){
    if(bin.length()==5){
       bin="000"+bin;
     }
    else if (bin.length()==6){
      bin="00" + bin;
    }
     else if(bin.length()==7){
      bin="0"+bin;
    }
   return bin;
  }

 
  
   
 

  

  
  
  int indexOf(char ch, char[] arry){
    for(int x=0; x<=arry.length-1; x++){
      if(arry[x]==ch){
        return x;
      }
    }
    return -1;
  }
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }
  
}
