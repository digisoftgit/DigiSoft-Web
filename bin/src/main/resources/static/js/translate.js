
i18next.init({
    lng: 'en',
    debug: true,
    fallbackLng: 'en',
    resources: {
      en: {
        translation: {
          'menuItemFirst': 'home',
          'menuItemSecond': 'about us',
          'menuItemThird': 'portfolio',
          'menuItemFourth': 'Contact us',
          'menuItemFifth': 'lang',
          'aboutUs':'about us',
          'contactUs': 'contact us',
          'ourClients': 'ourClients',
          'ourPortfolio': 'our Portfolio',
          'address': 'Address',
          'phoneNumber': 'Phone Number:',
          'email': 'Email:',  
          'copyright': '&copy; Copyright Digisoft. All Rights Reserved',
          'addressValue': 'Orbeli brothers 4, Yerevan'
        }    
      },
      hy: {
        translation: {
          'menuItemFirst': 'Գլխավոր',
          'menuItemSecond': 'Մեր մասին',
          'menuItemThird': 'Պորտֆոլիո',
          'menuItemFourth': 'Հետադարձ կապ',
          'menuItemFifth': 'լեզու',
          'aboutUs':'Մեր մասին',
          'contactUs': 'Հետադարձ կապ',
          'ourClients': 'ՄԵՐ Հաճախորդները',
          'ourPortfolio': 'ՄԵՐ Պորտֆոլիոն',
          'address': 'հասցե',
          'phoneNumber': 'Հեռախոսահամար:',
          'email': 'Էլ. Փոստ:',
          'copyright': 'Բոլոր իրավունքները պաշտպանված են: Digisoft LLC',
          'addressValue': 'Օրբելի եղբայրներ 4, Երևան'
              }
      }, 
      ar: {
        translation: {
          'menuItemFirst': 'الصفحة الرئيسية',
          'menuItemSecond': 'من نحن',
          'menuItemThird': 'سندات',
          'menuItemFourth': 'للتواصل معنا',
          'menuItemFifth': 'اللغة',
          'aboutUs':'من نحن',
          'contactUs': 'للتواصل معنا',
          'ourClients': 'عملائنا',
          'ourPortfolio': 'سندات',
          'address': 'عنوان الشخص:',
          'phoneNumber': 'رقم الهاتف:',
          'email': ':البريد الإلكتروني'
                },
      },
      ru: {
        translation: {
          'menuItemFirst': 'Главная',
          'menuItemSecond': 'о нас',
          'menuItemThird': 'Портфолио',
          'menuItemFourth': 'Свяжитесь с нами',
          'menuItemFifth': 'Язык',
          'aboutUs':'о нас',
          'contactUs': 'Свяжитесь с нами',
          'ourClients': 'НАШИ КЛИЕНТЫ',
          'ourPortfolio' : 'Портфолио',
          'address': 'адрес',
          'phoneNumber': 'Телефонный номер:',
          'email': 'электронная почта:',
          'addressValue': 'Улица Братьев Орбели 4, Ереван'
                },
      }
    }
  }, function(err, t) {
    // init set content
    updateContent();
  });
  
  function updateContent() {
    document.querySelector('.menu_first_element').textContent = i18next.t('menuItemFirst');
    document.querySelector('.menu_second_element').textContent = i18next.t('menuItemSecond');
    document.querySelector('.menu_third_element').textContent = i18next.t('menuItemThird');
    document.querySelector('.menu_fourth_element').textContent = i18next.t('menuItemFourth');
    document.querySelector('.menu_fifth_element').textContent = i18next.t('menuItemFifth');
    document.querySelector('.about-header-title').textContent = i18next.t('aboutUs');
    document.querySelector('.contact-header-title').textContent = i18next.t('contactUs');
    document.querySelector('.clients-header-title').textContent = i18next.t('ourClients');
    document.querySelector('.clients-header-title').textContent = i18next.t('ourClients');
    document.querySelector('.portfolio-section-title').textContent =  i18next.t('ourPortfolio');
    document.querySelector('.address').textContent =  i18next.t('address');
    document.querySelector('.phone-number').textContent =  i18next.t('phoneNumber');
    document.querySelector('.email').textContent =  i18next.t('email');
    document.querySelector('.footer_contact').textContent = i18next.t('menuItemFourth');
    document.querySelector('.footer_phone').textContent = i18next.t('phoneNumber');
    document.querySelector('.footer_email').textContent = i18next.t('email');
    document.querySelector('.copyright').innerHTML = i18next.t('copyright');
    document.querySelector('.footer_address_value').innerHTML = i18next.t('addressValue');
  }
  
  function changeLng(lng) {
    i18next.changeLanguage(lng);
  }
  
  i18next.on('languageChanged', () => {
    updateContent();
  });