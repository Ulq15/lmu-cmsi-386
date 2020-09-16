function change(cents){
	try{
		if(cents<0) throw "Ammount cannot be negatve";
		if(isNaN(cents)) throw "Not a number";
		var coins = [0, 0, 0 ,0];
		var numOfCoins=0;
		
		numOfCoins=cents/25;
		coins[0]=numOfCoins;
		cents=cents-(numOfCoins*25);
		
		numOfCoins=cents/10;
		coins[1]=numOfCoins;
		cents=cents-(numOfCoins*10);
		
		numOfCoins=cents/5;
		coins[2]=numOfCoins;
		cents=cents-(numOfCoins*5);
		
		coins[0]=cents;
		
		return coins;
	}
	catch(err){
		message.innerHTML = err;
	}
}