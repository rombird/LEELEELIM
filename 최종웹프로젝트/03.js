const labels = ['2024년 12월', '2025년 1월', '2025년 2월', '2025년 3월', '2025년 4월', '2025년 5월'];

// 공통 옵션
const chartOptions = {
  responsive: true,
  interaction: { mode: 'index', intersect: false },
  stacked: false,
  plugins: {
    legend: { position: 'top' }
  },
  scales: {
    y: {
      type: 'linear',
      position: 'left',
      ticks: { callback: v => v + ' 억원' }
    },
    y1: {
      type: 'linear',
      position: 'right',
      grid: { drawOnChartArea: false },
      ticks: { callback: v => v + ' 만건' }
    }
  }
};

// 온라인 차트
new Chart(document.getElementById('onlineChart'), {
  type: 'bar',
  data: {
    labels: labels,
    datasets: [
      {
        label: '이용금액',
        type: 'bar',
        data: [1000, 600, 700, 900, 500, 550],
        backgroundColor: 'orange',
        yAxisID: 'y',
        order:1
      },
      {
        label: '이용건수',
        type: 'line',
        data: [100, 75, 80, 110, 85, 90],
        borderColor: 'blue',
        backgroundColor: 'blue',
        tension: 0.2,
        yAxisID: 'y1'
      }
    ]
  },
  options: chartOptions
});

// 오프라인 차트
new Chart(document.getElementById('offlineChart'), {
  type: 'bar',
  data: {
    labels: labels,
    datasets: [
      {
        label: '이용금액',
        type: 'bar',
        data: [1500, 800, 600, 1100, 1400, 1600],
        backgroundColor: 'orange',
        yAxisID: 'y',
        order:1
      },
      {
        label: '이용건수',
        type: 'line',
        data: [200, 120, 100, 150, 180, 190],
        borderColor: 'blue',
        backgroundColor: 'blue',
        tension: 0.2,
        yAxisID: 'y1'
      }
    ]
  },
  options: chartOptions
});
