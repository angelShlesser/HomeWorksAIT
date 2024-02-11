// 1. Поиск элементов для взаимодействия
// Элементы управления
const CITY_INPUT = document.querySelector("#city-input");
const SEARCH_BUTTON = document.querySelector(".search-button");

// Отображения данных которые придут в ответе
const WEATHER_CARD = document.querySelector(".weather-card");
const TEMP = document.querySelector(".temp");
const CITY_NAME = document.querySelector(".city-name");
const WEATHER_IMG = document.querySelector(".weather-img");
const ERROR_MASSAGE = document.querySelector(".error-message");
const ERROR = document.querySelector(".weather-error");
const FEELS = document.querySelector(".feels-temp")
const LOADING = document.querySelector("#circleG")

const API_KEY = "9596377cb4677464361ca985f665abb4";

const getWeatherByCityName = async () => {
  WEATHER_CARD.style.display = "none";
  ERROR.style.display = "none";
  LOADING.style.display = "flex"
  const CITY_INPUT_VALUE = CITY_INPUT.value.trim();

  if (CITY_INPUT_VALUE.length === 0) {
    ERROR_MASSAGE.innerHTML = "Please enter the city name!";
    ERROR.style.display = "flex";
    return;
  }

  const URL = `https://api.openweathermap.org/data/2.5/weather?q=${CITY_INPUT_VALUE}&appid=${API_KEY}`;

  try {
    const response = await fetch(URL);

    const result = await response.json();
    if (!response.ok) {
      throw Object.assign(new Error("Weather Error"), {
        response: result,
      });
    }

    // Тут пишете логику по работе с успешным ответом
    console.log(result);
    WEATHER_CARD.style.display = "flex";
    const iconUrl = `http://openweathermap.org/img/w/${result.weather[0].icon}.png`;

    TEMP.innerHTML = (result.main.temp - 273.15).toFixed(0) + "°C";
    FEELS.innerHTML = (result.main.feels_like- 273.15).toFixed(2) + "°C";
    CITY_NAME.innerHTML = result.name;
    WEATHER_IMG.src = iconUrl;
  } catch (error) {
    // Тут прописываете логику с ошибкой
    console.log(error.response);
    ERROR_MASSAGE.innerHTML = "Error fetching weather data.";
    ERROR.style.display = "flex";
  }
  finally{
    LOADING.style.display = "none"
  }
};

SEARCH_BUTTON.addEventListener("click", (event) => {
  event.preventDefault();
  getWeatherByCityName();
});
