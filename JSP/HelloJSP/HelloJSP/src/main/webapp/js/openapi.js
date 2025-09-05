/**
 * openapi.js
 */

let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=mzIa0gsCzwupEF2IZ%2BTN%2Fo%2F8C2B4Uz%2Ffzf1RP263VFM9MMG5d3dc2HTTVHtgGpcJZT042uKhw1kU2ZmFNaJBkg%3D%3D`;
	
document.querySelector('#search').addEventListener('change', function(e){
	let sido = e.target.value;
	searchCenterList(sido);
})

//검색 목록 생성
// 현재 우리가 <select>태그에 option으로 세개의 도시만 넣어둬서 충청북도와 같은 도시들은 검색을 할 수가 없으니 
// 데이터가 가지고 있는 도시만큼 목록을 생성하는 코드를 만들어 보겠다. 
fetch(url)
	.then(resolve => resolve.json())
	.then(result => {
		const search = document.querySelector('#search');
		result.data.reduce((acc, elem) => {
			//result.data : 센터목록을 담고 있는 배열
			if(acc.indexOf(elem.sido) == -1){
				acc.push(elem.sido);   // ['서울특별시', '제주자치도']
			}
			return acc;  // 다음순번의 acc값으로 활용
		}, [])
		.forEach(elem => {
			//<option valuce="서울특별시">서울특별시</option> 이걸 여기에서 만들려고 한다. 
			let opt = document.createElement('option');
			opt.value = elem;
			opt.innerHTML = elem;
			search.appendChild(opt);
		});
	})
	.catch(err => console.error(err)); 



searchCenterList('서울특별시');


//셀렉트 태그에 change이벤트가 발생하면 서울특별시는 서울~ 인천은 인천만~ 하는 코드를 아래에서 구현을 해봐라 
//(change이벤트 : option의 value가 달라질 때)
function searchCenterList(sido){
	fetch(url)
	.then(resolve => resolve.json())
	.then(result => {
		//목록 초기화
		document.querySelector('#list').innerHTML ='';
		
		result.data.forEach(elem =>{
			console.log(elem);
			if(elem.sido == sido){				
				let tr = document.createElement('tr');
				tr.addEventListener('click', function(e){
					window.open('daumapi.jsp?lat='+elem.lat+'&lng='+elem.lng);
				});
				['id', 'centerName', 'phoneNumber'].forEach(prop => {
					let td = document.createElement('td');
					td.innerText = elem[prop];
					tr.appendChild(td);
				})		
				document.querySelector('#list').appendChild(tr);	
			}
		});
	})
	.catch(err => console.error(err));	
}
	
