package by.training.nc.sd2.fapi.service.impl;

import by.training.nc.sd2.fapi.models.ServicesViewModel;
import by.training.nc.sd2.fapi.service.ServicesDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicesDataServiceImpl implements ServicesDataService {
    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public List<ServicesViewModel> getAll() {
        List<ServicesViewModel> servicesList = new ArrayList<>();
        ServicesViewModel user1 = new ServicesViewModel (1, "Yandex Music",
                "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "active");
        ServicesViewModel user2 = new ServicesViewModel (2, "Aleksandr", "Другая статистика\n" +
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
        ServicesViewModel user3 = new ServicesViewModel (3, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServicesViewModel user4 = new ServicesViewModel (4, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServicesViewModel user5 = new ServicesViewModel (5, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServicesViewModel user6 = new ServicesViewModel (6, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServicesViewModel user7 = new ServicesViewModel (7, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServicesViewModel user8 = new ServicesViewModel (8, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServicesViewModel user9 = new ServicesViewModel (9, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServicesViewModel user10 = new ServicesViewModel (10, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
                ".Музыки в высоком качестве; отключить рекламу; " +
                "пользоваться приложением и веб-версией сервиса в " +
                "любой стране мира; скачивать треки для прослушивания " +
                "в офлайн-режиме; использовать платные функции Яндекс.Радио: " +
                "пропускать любое количество треков и слушать радио без рекламы.", "notOwned");
        ServicesViewModel user11 = new ServicesViewModel (11, "Yandex Music", "Подписка позволяет: слушать любые треки из каталога Яндекс" +
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

        return servicesList;

        /*RestTemplate restTemplate = new RestTemplate();
        UserAccountViewModel[] billingAccountViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/billing-accounts/", UserAccountViewModel[].class);
        return billingAccountViewModelResponse == null ? Collections.emptyList() : Arrays.asList(billingAccountViewModelResponse);*/
    }


}
