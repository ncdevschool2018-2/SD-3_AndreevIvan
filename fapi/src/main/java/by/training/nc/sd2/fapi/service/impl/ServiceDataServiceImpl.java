package by.training.nc.sd2.fapi.service.impl;

import by.training.nc.sd2.fapi.models.ServiceViewModel;
import by.training.nc.sd2.fapi.service.ServiceDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ServiceDataServiceImpl implements ServiceDataService {
    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public List<ServiceViewModel> getAll() {
        /*List<ServiceViewModel> servicesList = new ArrayList<>();
        ServiceViewModel user1 = new ServiceViewModel (1, "Yandex Music",
                "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "active");
        ServiceViewModel user2 = new ServiceViewModel (2, "Aleksandr", "Другая статистика\n" +
                "Другую статистическую информацию и графики можно посмотреть в отчетах о прослушивании\n" +
                "\n" +
                "\n" +
                "Отчеты о прослушивании\n" +
                "Изучай недельные и годовые отчеты 1\n" +
                "\n" +
                "\n" +
                "Эксклюзивный доступ к новым функциям\n" +
                "Ты имеешь возможность раньше, чем другие, использовать новые функции\n" +
                "\n" +
                "\n" +
                "Отсутствие рекламы\n" +
                "Пользуйся веб-сайтом и мобильным приложением Last.fm без навязчивой баннерной рекламы 2\n" +
                "\n" +
                "\n" +
                "Скидки\n" +
                "Получи скидку 30% на товары в магазине Last.fm 3\n" +
                "\n" +
                "\n" +
                "Стильный значок подписчика\n" +
                "Черный значок подписчика на твоем фото в профиле свидетельствует о том, что ты поддерживаешь Last.fm",
                "banned");
        ServiceViewModel user3 = new ServiceViewModel (3, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServiceViewModel user4 = new ServiceViewModel (4, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServiceViewModel user5 = new ServiceViewModel (5, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServiceViewModel user6 = new ServiceViewModel (6, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServiceViewModel user7 = new ServiceViewModel (7, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServiceViewModel user8 = new ServiceViewModel (8, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServiceViewModel user9 = new ServiceViewModel (9, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServiceViewModel user10 = new ServiceViewModel (10, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServiceViewModel user11 = new ServiceViewModel (11, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "active");

        servicesList.add(user1);
        servicesList.add(user2);
        servicesList.add(user3);
        servicesList.add(user4);
        servicesList.add(user5);
        servicesList.add(user6);
        servicesList.add(user7);
        servicesList.add(user8);
        servicesList.add(user9);
        servicesList.add(user10);
        servicesList.add(user11);

        return servicesList;*/

        RestTemplate restTemplate = new RestTemplate();
        ServiceViewModel[] billingAccountViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/services-backend/", ServiceViewModel[].class);
        return billingAccountViewModelResponse == null ? Collections.emptyList() : Arrays.asList(billingAccountViewModelResponse);
    }
    @Override
    public ServiceViewModel createService(ServiceViewModel service) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(service.getName());
        return restTemplate.postForEntity(backendServerUrl + "/api/services-backend/", service, ServiceViewModel.class).getBody();
    }

}
