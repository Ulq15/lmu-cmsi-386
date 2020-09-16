function change(cents){
	try{
		if(cents<0) throw RangeError("ammount cannot be negatve");
		if(isNaN(cents)) throw "Not a number";
		var coins = [0, 0, 0 ,0];
		var numOfCoins=0;
		
		numOfCoins=cents/25;
		numOfCoins=Math.floor(numOfCoins);
		coins[0]=numOfCoins;
		cents=cents-(numOfCoins*25);
		
		numOfCoins=cents/10;
		numOfCoins=Math.floor(numOfCoins);
		coins[1]=numOfCoins;
		cents=cents-(numOfCoins*10);
		
		numOfCoins=cents/5;
		numOfCoins=Math.floor(numOfCoins);
		coins[2]=numOfCoins;
		cents=cents-(numOfCoins*5);
		
		coins[3]=cents;
		return coins;
	}
	catch(err){
		return err;
	}
}

function stretched(str2BS){ //str2BS means "String To Be Stretched"
	str2BS=str2BS.replace(/\s/g,"");
	var strS=""; //strS means "String Stretched"
	for(i=0; i < str2BS.length; i++){
		for(j=0; j<=i; j++){
			strS=strS.concat(str2BS.charAt(i));
		}
	}
	return strS;
}

function scramble(str2BS){ //str2BS means "String To Be Scrambled"
	var array = str2BS.split("");
	var size = array.length;
	for(i=size-1; i>0;i--){
		var j = Math.floor(Math.random()*(i+1));
		var temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	var scrambled=array.join("");
	return scrambled;
}

function powers(base, limit, callback){
	var result=1;
	while(result<=limit){
		callback(result);
		result=result*base;
	}
}

function* powersGenerator(base, limit){
	var result=1;
	while(result<=limit){
		yield result;
		result=result*base;
	}
}

function say(str){
	var result;
	if(str){
		result=str;
		let recursor=function(b){
			if(b){
				result=result+" "+b;
				return recursor;
			}
			else{
				return result;
			}
		};
		return recursor;
	} else{
		return '';
	}
}

function interleave(array, ...args){
	let i=1;
	for(const item of args){
		if(i<array.length){
			array.splice(i, 0, item);
		} else{
			array.push(item);
		}
		i+=2;
	}
	return array;
}


function makeCryptoFunctions(key, algorithm, iVector){
	let e = function(text){
		let crypto;
		try {
 			crypto = require('crypto');
		} catch (err) {
  			console.log('crypto support is disabled!');
		}
		let cipher = crypto.createCipheriv(algorithm, Buffer.from(key), iVector);
		let encrypted = cipher.update(text);
		encrypted =Buffer.concat([encrypted, cipher.final()]);
		return encrypted.toString('hex');
	};
	let d = function(text){
		let crypto;
		try {
 			crypto = require('crypto');
		} catch (err) {
  			console.log('crypto support is disabled!');
		}
 		let encryptedText = Buffer.from(text, 'hex');
		let decipher = crypto.createDecipheriv(algorithm, Buffer.from(key), iVector);
		let decrypted=decipher.update(encryptedText);
		decrypted = Buffer.concat([decrypted, decipher.final()]); 
		return decrypted.toString(); 
	};
	return [e,d];
}

