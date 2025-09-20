const chartStrat1 = document.getElementById('bar-chart1');

// 1번 차트에 들어갈 데이터셋

const datasets = {
  item: {
    labels: ["포켓몬", "피카츄", "꼬부기", "야도란", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스"],
    data: [2478, 5267, 734, 784, 433, 500, 500, 500, 500, 500, 500, 500, 500]
  },

  color: {
    labels: ["한국", "일본", "중국", "대만", "홍콩", "캄보디아", "말레이시아", "싱가포르", "인도네시아", "호주", "뉴질랜드", "투발루", "칠레"],
    data: [1478, 3267, 1734, 3784, 2433, 900, 200, 1500, 3500, 500, 500, 500, 500]
  },

  material: {
    labels: ["포켓몬", "피카츄", "꼬부기", "야도란", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스"],
    data: [378, 1267, 1734, 2784, 233, 700, 3500, 2500, 500, 500, 500, 500, 500]
  },

  print: {
    labels: ["포켓몬", "피카츄", "꼬부기", "야도란", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스"],
    data: [4478, 2267, 1234, 1484, 1533, 1200, 2100, 3500, 500, 500, 500, 500, 500]
  },

  superStyle: {
    labels: ["포켓몬", "피카츄", "꼬부기", "야도란", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스"],
    data: [1578, 1267, 2734, 4784, 2433, 3500, 2500, 500, 500, 500, 500, 500, 500]
  }
};



// 1번 차트 구조 짜는 코드
const chart = new Chart(chartStrat1, {
  type: 'bar',
  data: {
    labels: datasets.item.labels,

    datasets: [
      {
        label: "신나는 대모험",
        backgroundColor: ["#3e53cdff", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850", , "#c45850", "#c45850", "#c45850", "#c45850", "#c45850", "#c45850", "#c45850", "#c45850"],
        data: datasets.item.data
      }
    ]
  },
  options: {
    responsive: true,
    maintainAspectRatio: false,
    animation: {
      duration: 1500,
      easing: 'easeOut'
    },
    scales: {
      y: {
        beginAtZero: true,

        title: {
          display: true,
          text: "포켓몬"
        }
      }

    }
  }
});

// 1번 차트 클릭에 따라 불러오는 코드
document.querySelectorAll('input[name = "runwayBtn"]').forEach(radio => {
  radio.addEventListener('change', e => {
    const selected = e.target.value;
    chart.data.labels = datasets[selected].labels;
    chart.data.datasets[0].data = datasets[selected].data;
    chart.data.datasets[0].label = selected;
    chart.update();
  });
});



const chartStrat2 = document.getElementById('bar-chart2');

// 2번 차트에 들어갈 데이터셋

const datasets2 = {
  item: {
    labels: ["너목들", "태양의 후예", "미스터선샤인", "그녀는예뻣다", "시그널", "이태원클라스", "도깨비", "지붕뚫고하이킥", "거침없이하이킥", "이상한 변호사 우영우", "내 여자친구는 구미호", "불멸의 이순신", "별에서 온 그대"],
    data: [3123, 123, 1231, 412, 1231, 1234, 5325, 463, 214, 4543, 500, 500, 500]
  },

  color: {
    labels: ["한국", "일본", "중국", "대만", "홍콩", "캄보디아", "말레이시아", "싱가포르", "인도네시아", "호주", "뉴질랜드", "투발루", "칠레"],
    data: [1478, 3267, 1734, 3784, 2433, 900, 200, 1500, 3500, 500, 500, 500, 500]
  },

  material: {
    labels: ["포켓몬", "피카츄", "꼬부기", "야도란", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스"],
    data: [378, 1267, 1734, 3232, 233, 700, 3500, 2500, 500, 500, 500, 500, 500]
  },

  print: {
    labels: ["포켓몬", "피카츄", "꼬부기", "야도란", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스"],
    data: [4231, 3213, 1233, 4124, 123, 1321, 2134, 3500, 500, 500, 500, 500, 500]
  },

  superStyle: {
    labels: ["포켓몬", "피카츄", "꼬부기", "야도란", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스", "또가스"],
    data: [1578, 2312, 2121, 3213, 3213, 3500, 1231, 500, 500, 500, 500, 500, 500]
  }
};


// 2번 차트 구조 짜는 코드
const chart2 = new Chart(chartStrat2, {
  type: 'bar',
  data: {
    labels: datasets2.item.labels,

    datasets: [
      {
        label: "신나는 대모험",
        backgroundColor: ["#3e53cdff", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850", , "#c45850", "#c45850", "#c45850", "#c45850", "#c45850", "#c45850", "#c45850", "#c45850"],
        data: datasets2.item.data
      }
    ]
  },
  options: {
    responsive: true,
    maintainAspectRatio: false,
    animation: {
      duration: 1500,
      easing: 'easeOut'
    },
    scales: {
      y: {
        beginAtZero: true,

        title: {
          display: true,
          text: "포켓몬"
        }
      }
    }
  }
});



// 2번 차트 클릭에 따라 불러오는 코드
document.querySelectorAll('input[name = "runwayBtn"]').forEach(radio => {
  radio.addEventListener('change', e => {
    const selected = e.target.value;
    chart2.data.labels = datasets2[selected].data;
    chart2.data.datasets[0].data = datasets2[selected].data;
    chart2.data.datasets[0].label = selected;
    chart2.update();
  });
});













// e -commerce에 차트 불러오기 버튼
const rankData = {
  "202509": [
    { rank: "1위", name: "드레스", change: "-", percent: "21.28%" },
    { rank: "2위", name: "팬츠", change: "▲ 2", percent: "15.00%" },
    { rank: "3위", name: "탑", change: "▼ 1", percent: "10.00%" },
    { rank: "4위", name: "스커트", change: "-", percent: "8.00%" },
    { rank: "5위", name: "재킷", change: "-", percent: "7.00%" },
    { rank: "6위", name: "셔츠", change: "▼ 2", percent: "6.00%" },
    { rank: "7위", name: "니트웨어", change: "▲ 1", percent: "5.00%" },
    { rank: "8위", name: "청바지", change: "-", percent: "4.00%" },
    { rank: "9위", name: "블라우스", change: "▲ 3", percent: "3.00%" },
    { rank: "10위", name: "코트", change: "-", percent: "2.50%" }
  ],
  "202508": [
    { rank: "1위", name: "꽃무늬", change: "-", percent: "18.00%" },
    { rank: "2위", name: "뱀무늬", change: "▼ 1", percent: "16.00%" },
    { rank: "3위", name: "사자무늬", change: "▲ 2", percent: "12.00%" },
    { rank: "4위", name: "호랑이무늬", change: "-", percent: "11.00%" },
    { rank: "5위", name: "거미무늬", change: "-", percent: "9.00%" },
    { rank: "6위", name: "개미무늬", change: "▼ 2", percent: "7.00%" },
    { rank: "7위", name: "벌무늬", change: "-", percent: "6.00%" },
    { rank: "8위", name: "별무늬", change: "-", percent: "5.00%" },
    { rank: "9위", name: "독수리무늬", change: "-", percent: "3.50%" },
    { rank: "10위", name: "오리무늬", change: "-", percent: "2.00%" },
    { rank: "11위", name: "소무늬", change: "-", percent: "3.50%" },
    { rank: "12위", name: "쥐무늬", change: "-", percent: "3.50%" },
    { rank: "13위", name: "개무늬", change: "-", percent: "3.50%" },
  ],
  "202507": [
    { rank: "1위", name: "드레스", change: "-", percent: "21.28%" },
    { rank: "2위", name: "팬츠", change: "▲ 2", percent: "15.00%" },
    { rank: "3위", name: "탑", change: "▼ 1", percent: "10.00%" },
    { rank: "4위", name: "스커트", change: "-", percent: "8.00%" },
    { rank: "5위", name: "재킷", change: "-", percent: "7.00%" },
    { rank: "6위", name: "셔츠", change: "▼ 2", percent: "6.00%" },
    { rank: "7위", name: "니트웨어", change: "▲ 1", percent: "5.00%" },
    { rank: "8위", name: "청바지", change: "-", percent: "4.00%" },
    { rank: "9위", name: "블라우스", change: "▲ 3", percent: "3.00%" },
    { rank: "10위", name: "코트", change: "-", percent: "2.50%" }
  ],
  "202506": [
    { rank: "1위", name: "드레스", change: "-", percent: "21.28%" },
    { rank: "2위", name: "팬츠", change: "▲ 2", percent: "15.00%" },
    { rank: "3위", name: "탑", change: "▼ 1", percent: "10.00%" },
    { rank: "4위", name: "스커트", change: "-", percent: "8.00%" },
    { rank: "5위", name: "재킷", change: "-", percent: "7.00%" },
    { rank: "6위", name: "셔츠", change: "▼ 2", percent: "6.00%" },
    { rank: "7위", name: "니트웨어", change: "▲ 1", percent: "5.00%" },
    { rank: "8위", name: "청바지", change: "-", percent: "4.00%" },
    { rank: "9위", name: "블라우스", change: "▲ 3", percent: "3.00%" },
    { rank: "10위", name: "코트", change: "-", percent: "2.50%" }
  ],
  "202505": [
    { rank: "1위", name: "드레스", change: "-", percent: "21.28%" },
    { rank: "2위", name: "팬츠", change: "▲ 2", percent: "15.00%" },
    { rank: "3위", name: "탑", change: "▼ 1", percent: "10.00%" },
    { rank: "4위", name: "스커트", change: "-", percent: "8.00%" },
    { rank: "5위", name: "재킷", change: "-", percent: "7.00%" },
    { rank: "6위", name: "셔츠", change: "▼ 2", percent: "6.00%" },
    { rank: "7위", name: "니트웨어", change: "▲ 1", percent: "5.00%" },
    { rank: "8위", name: "청바지", change: "-", percent: "4.00%" },
    { rank: "9위", name: "블라우스", change: "▲ 3", percent: "3.00%" },
    { rank: "10위", name: "코트", change: "-", percent: "2.50%" }
  ],
  "202504": [
    { rank: "1위", name: "드레스", change: "-", percent: "21.28%" },
    { rank: "2위", name: "팬츠", change: "▲ 2", percent: "15.00%" },
    { rank: "3위", name: "탑", change: "▼ 1", percent: "10.00%" },
    { rank: "4위", name: "스커트", change: "-", percent: "8.00%" },
    { rank: "5위", name: "재킷", change: "-", percent: "7.00%" },
    { rank: "6위", name: "셔츠", change: "▼ 2", percent: "6.00%" },
    { rank: "7위", name: "니트웨어", change: "▲ 1", percent: "5.00%" },
    { rank: "8위", name: "청바지", change: "-", percent: "4.00%" },
    { rank: "9위", name: "블라우스", change: "▲ 3", percent: "3.00%" },
    { rank: "10위", name: "코트", change: "-", percent: "2.50%" }
  ],
  "202503": [
    { rank: "1위", name: "드레스", change: "-", percent: "21.28%" },
    { rank: "2위", name: "팬츠", change: "▲ 2", percent: "15.00%" },
    { rank: "3위", name: "탑", change: "▼ 1", percent: "10.00%" },
    { rank: "4위", name: "스커트", change: "-", percent: "8.00%" },
    { rank: "5위", name: "재킷", change: "-", percent: "7.00%" },
    { rank: "6위", name: "셔츠", change: "▼ 2", percent: "6.00%" },
    { rank: "7위", name: "니트웨어", change: "▲ 1", percent: "5.00%" },
    { rank: "8위", name: "청바지", change: "-", percent: "4.00%" },
    { rank: "9위", name: "블라우스", change: "▲ 3", percent: "3.00%" },
    { rank: "10위", name: "코트", change: "-", percent: "2.50%" }
  ],
  "202502": [
    { rank: "1위", name: "드레스", change: "-", percent: "21.28%" },
    { rank: "2위", name: "팬츠", change: "▲ 2", percent: "15.00%" },
    { rank: "3위", name: "탑", change: "▼ 1", percent: "10.00%" },
    { rank: "4위", name: "스커트", change: "-", percent: "8.00%" },
    { rank: "5위", name: "재킷", change: "-", percent: "7.00%" },
    { rank: "6위", name: "셔츠", change: "▼ 2", percent: "6.00%" },
    { rank: "7위", name: "니트웨어", change: "▲ 1", percent: "5.00%" },
    { rank: "8위", name: "청바지", change: "-", percent: "4.00%" },
    { rank: "9위", name: "블라우스", change: "▲ 3", percent: "3.00%" },
    { rank: "10위", name: "코트", change: "-", percent: "2.50%" }
  ],
  "202501": [
    { rank: "1위", name: "드레스", change: "-", percent: "21.28%" },
    { rank: "2위", name: "팬츠", change: "▲ 2", percent: "15.00%" },
    { rank: "3위", name: "탑", change: "▼ 1", percent: "10.00%" },
    { rank: "4위", name: "스커트", change: "-", percent: "8.00%" },
    { rank: "5위", name: "재킷", change: "-", percent: "7.00%" },
    { rank: "6위", name: "셔츠", change: "▼ 2", percent: "6.00%" },
    { rank: "7위", name: "니트웨어", change: "▲ 1", percent: "5.00%" },
    { rank: "8위", name: "청바지", change: "-", percent: "4.00%" },
    { rank: "9위", name: "블라우스", change: "▲ 3", percent: "3.00%" },
    { rank: "10위", name: "코트", change: "-", percent: "2.50%" }
  ],
  "202412": [
    { rank: "1위", name: "드레스", change: "-", percent: "21.28%" },
    { rank: "2위", name: "팬츠", change: "▲ 2", percent: "15.00%" },
    { rank: "3위", name: "탑", change: "▼ 1", percent: "10.00%" },
    { rank: "4위", name: "스커트", change: "-", percent: "8.00%" },
    { rank: "5위", name: "재킷", change: "-", percent: "7.00%" },
    { rank: "6위", name: "셔츠", change: "▼ 2", percent: "6.00%" },
    { rank: "7위", name: "니트웨어", change: "▲ 1", percent: "5.00%" },
    { rank: "8위", name: "청바지", change: "-", percent: "4.00%" },
    { rank: "9위", name: "블라우스", change: "▲ 3", percent: "3.00%" },
    { rank: "10위", name: "코트", change: "-", percent: "2.50%" }
  ],
  "202411": [
    { rank: "1위", name: "드레스", change: "-", percent: "21.28%" },
    { rank: "2위", name: "팬츠", change: "▲ 2", percent: "15.00%" },
    { rank: "3위", name: "탑", change: "▼ 1", percent: "10.00%" },
    { rank: "4위", name: "스커트", change: "-", percent: "8.00%" },
    { rank: "5위", name: "재킷", change: "-", percent: "7.00%" },
    { rank: "6위", name: "셔츠", change: "▼ 2", percent: "6.00%" },
    { rank: "7위", name: "니트웨어", change: "▲ 1", percent: "5.00%" },
    { rank: "8위", name: "청바지", change: "-", percent: "4.00%" },
    { rank: "9위", name: "블라우스", change: "▲ 3", percent: "3.00%" },
    { rank: "10위", name: "코트", change: "-", percent: "2.50%" }
  ],
  "202410": [
    { rank: "1위", name: "드레스", change: "-", percent: "21.28%" },
    { rank: "2위", name: "팬츠", change: "▲ 2", percent: "15.00%" },
    { rank: "3위", name: "탑", change: "▼ 1", percent: "10.00%" },
    { rank: "4위", name: "스커트", change: "-", percent: "8.00%" },
    { rank: "5위", name: "재킷", change: "-", percent: "7.00%" },
    { rank: "6위", name: "셔츠", change: "▼ 2", percent: "6.00%" },
    { rank: "7위", name: "니트웨어", change: "▲ 1", percent: "5.00%" },
    { rank: "8위", name: "청바지", change: "-", percent: "4.00%" },
    { rank: "9위", name: "블라우스", change: "▲ 3", percent: "3.00%" },
    { rank: "10위", name: "코트", change: "-", percent: "2.50%" }
  ],
};


function renderRank(period) {
  const container = document.getElementById("eCommerceOuterbox");
  container.innerHTML = "";

  // 왼쪽 1~8, 오른쪽 9~10 이렇게 나눠서 넣기
  const leftBox = document.createElement("div");
  leftBox.className = "e-commerce-left-box";
  const rightBox = document.createElement("div");
  rightBox.className = "e-commerce-right-box";

  rankData[period].forEach((item, idx) => {
    const div = document.createElement("div");
    div.className = "rank-item";

    // 순위 up down에 따라 색깔 입히는거 
    let changeClass = "";
    if (item.change.includes("▲")) {
      changeClass = "up";
    } else if (item.change.includes("▼")) {
      changeClass = "down";
    } else {
      changeClass = "stable";
    }

    div.innerHTML = `
      <span class="rank-number">${item.rank}</span>
      <span class="name">${item.name}</span>
      <span class="up-down ${changeClass}">${item.change}</span>
      <span class="percentage">${item.percent}</span>
    `;
    if (idx < 8) {
      leftBox.appendChild(div);
    } else {
      rightBox.appendChild(div);
    }
  });

  container.appendChild(leftBox);
  container.appendChild(rightBox);
}

// 초기 렌더링
renderRank("202509");

// select 이벤트 연결
document.getElementById("ePeriodSelect").addEventListener("change", function () {
  renderRank(this.value);
});










