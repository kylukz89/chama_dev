package com.example.chama_kotlin

import org.json.JSONArray

class PlacesMapAPI {

    val URL_API = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants+in+Andradina&key=AIzaSyAoQZzw0aLm1Wk7T6wNV8Z74Yh4qfpuiB0"

    fun getRetornarPlacesPorGeolocalizcao(lat : String, lon : String) {
        var retorno = "{\n" +
                "    \"html_attributions\": [],\n" +
                "    \"next_page_token\": \"Aap_uECspSU9ukiK-D4bswdjm7FNaQR_QiWddJjoc3B-zZrMuz6zTgwxt5j9cKxhC99WyocaRtrMcjPEANG_j1_49ew0TBhf8EV6YxL1PomquTydqSqDNUbQc96c3XxNJuFavRIEloPeX2qcJgRn6QkjDmpfovStCXQaTVqcchgqHqJ21A9Oz-XYpucBLs1nI7pyBh_2Wl8Dw7XMnVw7dEkgWgeompcSlYsv2q2kQJxp29ZvpgJd9cgQzaqZK8WxXWnML9W_cSvpPCy5skyA8O-EQ1LuaT3vCrWJahmuxFNXxGKRr1WT4w14Kuqbu0OvpWualpuqTafOW-FCcei7u3ellrzdZ8fFoA3egNPUVxgzldrrrrHCA81ZGGopE0qDfbViOZHhlCulXHXYTUBvB4k\",\n" +
                "    \"results\": [\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. Pres. Vargas, 2335 - Vila Mineira, Andradina - SP, 16901-307, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.8918326,\n" +
                "                    \"lng\": -51.3682185\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.89050847010728,\n" +
                "                        \"lng\": -51.36682447010727\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.89320812989272,\n" +
                "                        \"lng\": -51.36952412989271\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Piloca Gás\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": false\n" +
                "            },\n" +
                "            \"photos\": [\n" +
                "                {\n" +
                "                    \"height\": 2322,\n" +
                "                    \"html_attributions\": [\n" +
                "                        \"<a href=\\\"https://maps.google.com/maps/contrib/113097723954129089653\\\">Davii Carmo</a>\"\n" +
                "                    ],\n" +
                "                    \"photo_reference\": \"Aap_uEDme9Zo3Eb4jkoiOLwakZ3_ta5KvbksljqCiG6itpRaqFV3PmrdmZcRSLeeFbjAjlM4o-Ai9Dntz5PRBfF8_P2KXmchlT8cjmKrDTxNfcrmx7kMmztKyueC6IvrVbxhTtJ0ZO6m5QeSt8Aylinyu02MTqiC93iikMJCptKUkeerMGCu\",\n" +
                "                    \"width\": 4128\n" +
                "                }\n" +
                "            ],\n" +
                "            \"place_id\": \"ChIJ6YJQAGC1kJQRDZdpHQ1DHr0\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"4J5J+7P Vila Mineira, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC4J5J+7P\"\n" +
                "            },\n" +
                "            \"rating\": 4.5,\n" +
                "            \"reference\": \"ChIJ6YJQAGC1kJQRDZdpHQ1DHr0\",\n" +
                "            \"types\": [\n" +
                "                \"food\",\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 64\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. Barão do Rio Branco, 1507 - Centro, Andradina - SP, 16901-001, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.899441,\n" +
                "                    \"lng\": -51.3786593\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.89814352010727,\n" +
                "                        \"lng\": -51.37734282010727\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.90084317989272,\n" +
                "                        \"lng\": -51.38004247989272\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Distribuidora Gás Castilho\",\n" +
                "            \"place_id\": \"ChIJQ5T4VYPKkJQR9Z1p4IeecD8\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"4J2C+6G Centro, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC4J2C+6G\"\n" +
                "            },\n" +
                "            \"rating\": 5,\n" +
                "            \"reference\": \"ChIJQ5T4VYPKkJQR9Z1p4IeecD8\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. Floriano Peixoto, 130 - Jardim Alvorada, Andradina - SP, 16900-058, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.9033736,\n" +
                "                    \"lng\": -51.3887335\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.90198652010728,\n" +
                "                        \"lng\": -51.38744782010728\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.90468617989272,\n" +
                "                        \"lng\": -51.39014747989273\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"RENOVA GÁS E ÁGUA MINERAL\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": false\n" +
                "            },\n" +
                "            \"photos\": [\n" +
                "                {\n" +
                "                    \"height\": 3264,\n" +
                "                    \"html_attributions\": [\n" +
                "                        \"<a href=\\\"https://maps.google.com/maps/contrib/109717537421361961504\\\">A Google User</a>\"\n" +
                "                    ],\n" +
                "                    \"photo_reference\": \"Aap_uEC-Tz29PqP0mTKXBUzk9eVM6Nss16gZqRs8RUzYmDMFuY8no89bTLAMnGZNibIWDw21e5QNavrZZ0rx4AuVGPIKX9IldE2o4K5ZzwgZoOBK0foZNa-uB9C54zSUR2adP7H-BYjPEB8lNXMYds02FkIN2gg7V4cFsW6_XJ5NjInYFets\",\n" +
                "                    \"width\": 2448\n" +
                "                }\n" +
                "            ],\n" +
                "            \"place_id\": \"ChIJl4SAgm-1kJQR75Lw2tLhfcQ\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"3JW6+MG Jardim Alvorada, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC3JW6+MG\"\n" +
                "            },\n" +
                "            \"rating\": 5,\n" +
                "            \"reference\": \"ChIJl4SAgm-1kJQR75Lw2tLhfcQ\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 10\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. Homero Rodrigues Silva, 2229 - Stella Maris, Andradina - SP, 16901-025, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.8874014,\n" +
                "                    \"lng\": -51.3772489\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.88607087010728,\n" +
                "                        \"lng\": -51.37586532010729\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.88877052989272,\n" +
                "                        \"lng\": -51.37856497989273\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Fiel Água e Gás\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": false\n" +
                "            },\n" +
                "            \"photos\": [\n" +
                "                {\n" +
                "                    \"height\": 469,\n" +
                "                    \"html_attributions\": [\n" +
                "                        \"<a href=\\\"https://maps.google.com/maps/contrib/112224163526282424758\\\">Thays Borim</a>\"\n" +
                "                    ],\n" +
                "                    \"photo_reference\": \"Aap_uEDshdhEwEbo6_sXOKs2qWWRMyszgru7eNBzTgggYmMQyuATS801Pu4UCb1dm27go-eawDuwRHd2RPch0KHVYuS8SLP_RILspK9VHrQjL8mBSnek-7V0CO_uR_xQHx0Vj--3rTuVMV5BgW6r-f2BJzrBkmWntRpNLr5szv7bZwKyORxc\",\n" +
                "                    \"width\": 793\n" +
                "                }\n" +
                "            ],\n" +
                "            \"place_id\": \"ChIJKRnaU5u1kJQRL-aulzasJMM\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"4J7F+24 Stella Maris, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC4J7F+24\"\n" +
                "            },\n" +
                "            \"rating\": 5,\n" +
                "            \"reference\": \"ChIJKRnaU5u1kJQRL-aulzasJMM\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. Rio de Janeiro, 1327 - Centro, Andradina - SP, 16900-027, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.9022599,\n" +
                "                    \"lng\": -51.3802855\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.90094817010728,\n" +
                "                        \"lng\": -51.37896127010728\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.90364782989272,\n" +
                "                        \"lng\": -51.38166092989272\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Armando Gulla\",\n" +
                "            \"place_id\": \"ChIJAbXbWITKkJQROH8NoetqdnQ\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"3JX9+3V Centro, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC3JX9+3V\"\n" +
                "            },\n" +
                "            \"rating\": 4.3,\n" +
                "            \"reference\": \"ChIJAbXbWITKkJQROH8NoetqdnQ\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 7\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"Av. Rio Grande do Sul, 626 - Vila Alpina, Andradina - SP, 16900-600, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.9033978,\n" +
                "                    \"lng\": -51.39104099999999\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.90199842010728,\n" +
                "                        \"lng\": -51.38965792010728\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.90469807989273,\n" +
                "                        \"lng\": -51.39235757989272\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"ULTRAGAZ-Novo Gás\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": false\n" +
                "            },\n" +
                "            \"photos\": [\n" +
                "                {\n" +
                "                    \"height\": 2322,\n" +
                "                    \"html_attributions\": [\n" +
                "                        \"<a href=\\\"https://maps.google.com/maps/contrib/100394919820542932302\\\">Fábio Olimpio</a>\"\n" +
                "                    ],\n" +
                "                    \"photo_reference\": \"Aap_uEBVZ7cgHGFKvuhRh0LE3cYJKUkJ47M1fXj6Mu1aQ6tt4NJwgeidWL2oexatc6v6Lm-OiFxi3r5OsLTRFUew6F1aP_LVt4p7qxvWF_CpnjlbeXiPbaucccdr_wI_MDHBItiTlKr0JK7Q3bBBHP_5Cl7VnP_Zsse0VyrzwFeww-oPGcCt\",\n" +
                "                    \"width\": 4128\n" +
                "                }\n" +
                "            ],\n" +
                "            \"place_id\": \"ChIJ95nb-mzLkJQRpFKSTHPkLKI\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"3JW5+JH Vila Alpina, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC3JW5+JH\"\n" +
                "            },\n" +
                "            \"rating\": 5,\n" +
                "            \"reference\": \"ChIJ95nb-mzLkJQRpFKSTHPkLKI\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. São Paulo, 1748 - Centro, Andradina - SP, 16901-024, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.9004271,\n" +
                "                    \"lng\": -51.3706343\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.89899362010728,\n" +
                "                        \"lng\": -51.36922922010728\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.90169327989272,\n" +
                "                        \"lng\": -51.37192887989273\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Copagaz Andradina\",\n" +
                "            \"photos\": [\n" +
                "                {\n" +
                "                    \"height\": 456,\n" +
                "                    \"html_attributions\": [\n" +
                "                        \"<a href=\\\"https://maps.google.com/maps/contrib/112546046806428109539\\\">A Google User</a>\"\n" +
                "                    ],\n" +
                "                    \"photo_reference\": \"Aap_uEDiPxUGC7xLwm-SWn6hF0WMjk7hOCJp9CHAALIyKatVSDTxkYxrJljDdQ_ypPogKdD6h_OH50vkdh0_R904MrH83D7xz8FbeGGE62-MH3p9RqZkBF2YABqU4ZNA0txiQ5eO3q2MKM63iJisE6cLyxh1SfIlKrGVDN-RhBC7TIUC3y0I\",\n" +
                "                    \"width\": 1000\n" +
                "                }\n" +
                "            ],\n" +
                "            \"place_id\": \"ChIJD0M1N3PLkJQRbo9Co7ikdqI\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"3JXH+RP Centro, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC3JXH+RP\"\n" +
                "            },\n" +
                "            \"rating\": 5,\n" +
                "            \"reference\": \"ChIJD0M1N3PLkJQRbo9Co7ikdqI\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. Paes Leme, 2542 - Stella Maris, Andradina - SP, 16901-110, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.8867404,\n" +
                "                    \"lng\": -51.3729514\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.88537217010728,\n" +
                "                        \"lng\": -51.37163392010728\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.88807182989272,\n" +
                "                        \"lng\": -51.37433357989273\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Chama Gás Andradina\",\n" +
                "            \"photos\": [\n" +
                "                {\n" +
                "                    \"height\": 2220,\n" +
                "                    \"html_attributions\": [\n" +
                "                        \"<a href=\\\"https://maps.google.com/maps/contrib/116781476406133356467\\\">A Google User</a>\"\n" +
                "                    ],\n" +
                "                    \"photo_reference\": \"Aap_uEDThoLV9ZiQWwz57Agyf8QV24rZOrYZw8SAYvhdjnPdLzVBwKj853wSLwsYVLG6r4GTpd2ug4c5TLJYe0bVIhNExcc4Katxhgx6LMyxnit276sf7hSyB4fnofBYdMOu-sy7cIXVVoenbhO0WpsEEqBi0dw0qFD7LAQywBhuoEX1YHL0\",\n" +
                "                    \"width\": 1080\n" +
                "                }\n" +
                "            ],\n" +
                "            \"place_id\": \"ChIJE_sYSu3LkJQReJCPQP7nO_4\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"4J7G+8R Stella Maris, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC4J7G+8R\"\n" +
                "            },\n" +
                "            \"rating\": 0,\n" +
                "            \"reference\": \"ChIJE_sYSu3LkJQReJCPQP7nO_4\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. Rio de Janeiro, 279 - Vila Passarelli, Andradina - SP, 16900-080, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.8962012,\n" +
                "                    \"lng\": -51.3907685\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.89484457010728,\n" +
                "                        \"lng\": -51.38941442010727\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.89754422989272,\n" +
                "                        \"lng\": -51.39211407989272\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Malaquias Gás\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": false\n" +
                "            },\n" +
                "            \"photos\": [\n" +
                "                {\n" +
                "                    \"height\": 3120,\n" +
                "                    \"html_attributions\": [\n" +
                "                        \"<a href=\\\"https://maps.google.com/maps/contrib/118322178940604046264\\\">Junior Malaquias</a>\"\n" +
                "                    ],\n" +
                "                    \"photo_reference\": \"Aap_uEALZMNHspHakzxOCFzPbcDAAgx1b4xJncXzh5zAooqy3LwucnT_l-x2-8hsmMp4_8SE-0CDFgrskjpbXToxnezDbSSZaP-ViTZ7cfzxluQzcvcORTpdmD4asjth3bClCfZodW9tLhfh_icibGW3CPsmFmv7a08uYkg6wrd79zemgT6p\",\n" +
                "                    \"width\": 4160\n" +
                "                }\n" +
                "            ],\n" +
                "            \"place_id\": \"ChIJzRgWAYC1kJQRR9GQe4CbAH8\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"4J35+GM Vila Passarelli, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC4J35+GM\"\n" +
                "            },\n" +
                "            \"rating\": 4.5,\n" +
                "            \"reference\": \"ChIJzRgWAYC1kJQRR9GQe4CbAH8\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 2\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"Av. Bandeirantes, 2179 - Piscina, Andradina - SP, 16901-445, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.9029901,\n" +
                "                    \"lng\": -51.367423\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.90168562010728,\n" +
                "                        \"lng\": -51.36610347010728\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.90438527989272,\n" +
                "                        \"lng\": -51.36880312989273\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Andragás Gás e Água Mineral\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": false\n" +
                "            },\n" +
                "            \"place_id\": \"ChIJDxD87X3LkJQRzSEUxE7iJlw\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"3JWM+R2 Piscina, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC3JWM+R2\"\n" +
                "            },\n" +
                "            \"rating\": 0,\n" +
                "            \"reference\": \"ChIJDxD87X3LkJQRzSEUxE7iJlw\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"Av. Barão do Rio Branco - Vila Passarelli, Andradina - SP, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.8945511,\n" +
                "                    \"lng\": -51.38721880000001\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.89317477010727,\n" +
                "                        \"lng\": -51.38585117010727\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.89587442989272,\n" +
                "                        \"lng\": -51.38855082989272\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Ultragaz Barão\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": false\n" +
                "            },\n" +
                "            \"photos\": [\n" +
                "                {\n" +
                "                    \"height\": 455,\n" +
                "                    \"html_attributions\": [\n" +
                "                        \"<a href=\\\"https://maps.google.com/maps/contrib/112546046806428109539\\\">A Google User</a>\"\n" +
                "                    ],\n" +
                "                    \"photo_reference\": \"Aap_uEBjto8hG8gZ9ciS_2tDMPqa1tMTeFh2reQJj3R6tMSBfqkFE_o5PnQ9GCY2jhCQFgZsJ3RlcNw3QvhkkoZVi-MMdZuJjuEbNXyv-IfGQMxWqQeBUgx3DTIXtGyxrKKsYamaCHP8Tnp0j4HTGzX1ifdoh6HNT13H3XgKFd1sJTgPwqS_\",\n" +
                "                    \"width\": 715\n" +
                "                }\n" +
                "            ],\n" +
                "            \"place_id\": \"ChIJq1ZtNKC1kJQRBLvyWRQ6KsY\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"4J47+54 Andradina, State of São Paulo\",\n" +
                "                \"global_code\": \"58FC4J47+54\"\n" +
                "            },\n" +
                "            \"rating\": 0,\n" +
                "            \"reference\": \"ChIJq1ZtNKC1kJQRBLvyWRQ6KsY\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. Padre Anchieta, 62 - Jardim Santa Cecilia, Andradina - SP, 16902-055, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.9081064,\n" +
                "                    \"lng\": -51.3598368\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.90674472010728,\n" +
                "                        \"lng\": -51.35841602010728\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.90944437989272,\n" +
                "                        \"lng\": -51.36111567989272\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"DISTRIBUIDORA DE ÁGUA E GÁS SANTA CECÍLIA\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": false\n" +
                "            },\n" +
                "            \"photos\": [\n" +
                "                {\n" +
                "                    \"height\": 1920,\n" +
                "                    \"html_attributions\": [\n" +
                "                        \"<a href=\\\"https://maps.google.com/maps/contrib/108491020917488615737\\\">A Google User</a>\"\n" +
                "                    ],\n" +
                "                    \"photo_reference\": \"Aap_uEBVh4NlvdFH6QTfEBYI7G1IUJQsVNnI1syiwzo1HxvVtWtpi2RJnCBZ3qFV2WlE4-31AfelKOyrfWOEILvE9j3_RBXlL1uBeOY5Ua_FjdsAR6Zr6QfmYw2LxKF_t2zv1AvwqnGoaKSED2cOqAJTdVx73m0LuzvHEcHpEc3_jSMFTKDb\",\n" +
                "                    \"width\": 1080\n" +
                "                }\n" +
                "            ],\n" +
                "            \"place_id\": \"ChIJlXeUW7jKkJQRbNj8Fjn7zRY\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"3JRR+Q3 Jardim Santa Cecilia, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC3JRR+Q3\"\n" +
                "            },\n" +
                "            \"rating\": 4.8,\n" +
                "            \"reference\": \"ChIJlXeUW7jKkJQRbNj8Fjn7zRY\",\n" +
                "            \"types\": [\n" +
                "                \"food\",\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 8\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. Shigueo Abe, 49 - Centro, Andradina - SP, 16900-001, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.9084076,\n" +
                "                    \"lng\": -51.3815957\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.90707777010728,\n" +
                "                        \"lng\": -51.38020942010728\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.90977742989272,\n" +
                "                        \"lng\": -51.38290907989273\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Silva Gás\",\n" +
                "            \"place_id\": \"ChIJJwKh_I7KkJQRPeVJq0y-cPI\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"3JR9+J9 Centro, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC3JR9+J9\"\n" +
                "            },\n" +
                "            \"rating\": 5,\n" +
                "            \"reference\": \"ChIJJwKh_I7KkJQRPeVJq0y-cPI\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. Floriano Peixoto, 130 - Jardim Alvorada, Andradina - SP, 16900-058, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.9033736,\n" +
                "                    \"lng\": -51.3887335\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.90198652010728,\n" +
                "                        \"lng\": -51.38744782010728\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.90468617989272,\n" +
                "                        \"lng\": -51.39014747989273\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Revenda Ultragaz\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": false\n" +
                "            },\n" +
                "            \"place_id\": \"ChIJUy9QyWnLkJQRcPXGbXEEaUk\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"3JW6+MG Jardim Alvorada, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC3JW6+MG\"\n" +
                "            },\n" +
                "            \"rating\": 2,\n" +
                "            \"reference\": \"ChIJUy9QyWnLkJQRcPXGbXEEaUk\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. Guiomar Soares de Andrade, 496 - Vila Pereira Jordao, Andradina - SP, 16903-000, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.907215,\n" +
                "                    \"lng\": -51.3920416\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.90586287010728,\n" +
                "                        \"lng\": -51.39072542010727\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.90856252989273,\n" +
                "                        \"lng\": -51.39342507989272\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Lua Gás\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": false\n" +
                "            },\n" +
                "            \"photos\": [\n" +
                "                {\n" +
                "                    \"height\": 500,\n" +
                "                    \"html_attributions\": [\n" +
                "                        \"<a href=\\\"https://maps.google.com/maps/contrib/107486781790900578303\\\">A Google User</a>\"\n" +
                "                    ],\n" +
                "                    \"photo_reference\": \"Aap_uEA247DrkZ64mi1U9LBdC3tiWBITv10mDpWKVjrvN8rOKEQHh6nBAmUCynKqPWrXbE-NdkHFy1QEjQmRC1zLbHtxhSxOq6Cn96z5RhI0H9VT3d47kCwb4k59wJQ39g-PshI_pWp5EHqDCWJyg1Z-8LwracHILeiztX7d0rEms5YssCfA\",\n" +
                "                    \"width\": 500\n" +
                "                }\n" +
                "            ],\n" +
                "            \"place_id\": \"ChIJF1S0K-zLkJQRoD0ZkOxqCik\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"3JV5+45 Vila Pereira Jordao, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC3JV5+45\"\n" +
                "            },\n" +
                "            \"rating\": 0,\n" +
                "            \"reference\": \"ChIJF1S0K-zLkJQRoD0ZkOxqCik\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. São Paulo, 1756 - Centro, Andradina - SP, 16901-024, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.9003675,\n" +
                "                    \"lng\": -51.3704895\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.89898582010727,\n" +
                "                        \"lng\": -51.36911867010728\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.90168547989272,\n" +
                "                        \"lng\": -51.37181832989272\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Leve Gás E Água\",\n" +
                "            \"place_id\": \"ChIJ8_uPVJjKkJQRU90zBuydMv4\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"3JXH+VR Centro, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC3JXH+VR\"\n" +
                "            },\n" +
                "            \"rating\": 0,\n" +
                "            \"reference\": \"ChIJ8_uPVJjKkJQRU90zBuydMv4\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"Av. Rio Grande do Sul, 626 - Jardim Alvorada, Andradina - SP, 16900-063, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.9139722,\n" +
                "                    \"lng\": -51.37284\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.91259577010728,\n" +
                "                        \"lng\": -51.37147212010728\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.91529542989272,\n" +
                "                        \"lng\": -51.37417177989272\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Revenda Ultragaz\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": false\n" +
                "            },\n" +
                "            \"place_id\": \"ChIJ_QT42lLLkJQRWhgBR_N50nM\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"3JPG+CV Jardim Alvorada, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC3JPG+CV\"\n" +
                "            },\n" +
                "            \"rating\": 0,\n" +
                "            \"reference\": \"ChIJ_QT42lLLkJQRWhgBR_N50nM\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. Barão do Rio Branco, 1507 - Centro, Andradina - SP, 16980-000, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.8993997,\n" +
                "                    \"lng\": -51.3787285\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.89810192010728,\n" +
                "                        \"lng\": -51.37741342010727\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.90080157989273,\n" +
                "                        \"lng\": -51.38011307989272\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Revenda Ultragaz\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": false\n" +
                "            },\n" +
                "            \"place_id\": \"ChIJ3fmmwZtbzpQRCfRqnmm1ips\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"4J2C+6G Centro, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC4J2C+6G\"\n" +
                "            },\n" +
                "            \"rating\": 5,\n" +
                "            \"reference\": \"ChIJ3fmmwZtbzpQRCfRqnmm1ips\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"R. Barão do Rio Branco, 1727 - Centro, Andradina - SP, 16901-014, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.9046897,\n" +
                "                    \"lng\": -51.3696509\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.90343257010727,\n" +
                "                        \"lng\": -51.36836592010727\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.90613222989272,\n" +
                "                        \"lng\": -51.37106557989271\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Gás e Água Mineral Ribeiro\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": false\n" +
                "            },\n" +
                "            \"place_id\": \"ChIJJ5fJFZvKkJQRu88OzU6HmWk\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"3JWJ+44 Centro, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC3JWJ+44\"\n" +
                "            },\n" +
                "            \"rating\": 4,\n" +
                "            \"reference\": \"ChIJJ5fJFZvKkJQRu88OzU6HmWk\",\n" +
                "            \"types\": [\n" +
                "                \"food\",\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_status\": \"OPERATIONAL\",\n" +
                "            \"formatted_address\": \"Av. Rio Grande do Sul, 1371 - Vila Sanches, Andradina - SP, 16900-063, Brazil\",\n" +
                "            \"geometry\": {\n" +
                "                \"location\": {\n" +
                "                    \"lat\": -20.9065332,\n" +
                "                    \"lng\": -51.3852346\n" +
                "                },\n" +
                "                \"viewport\": {\n" +
                "                    \"northeast\": {\n" +
                "                        \"lat\": -20.90523857010728,\n" +
                "                        \"lng\": -51.38392452010728\n" +
                "                    },\n" +
                "                    \"southwest\": {\n" +
                "                        \"lat\": -20.90793822989272,\n" +
                "                        \"lng\": -51.38662417989272\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png\",\n" +
                "            \"name\": \"Bellágua\",\n" +
                "            \"opening_hours\": {\n" +
                "                \"open_now\": false\n" +
                "            },\n" +
                "            \"photos\": [\n" +
                "                {\n" +
                "                    \"height\": 603,\n" +
                "                    \"html_attributions\": [\n" +
                "                        \"<a href=\\\"https://maps.google.com/maps/contrib/108963677764918202829\\\">A Google User</a>\"\n" +
                "                    ],\n" +
                "                    \"photo_reference\": \"Aap_uEC6Q2CAoR5QINokn9Ukvf0SNT9FIbO0pyvBwyEJjwZuq71om5eX2Ldg0t44zLAQPmeXDVKHfC6YNWhzoIu036vAW3RdAQVnb6Rqqpo42j9TfMD1RW7Jq6wbBcDZ4G2YLPQbp2xvN0T7z8ifkXcHVBVbTokIt_dkxjscC2aH37CU4Rgq\",\n" +
                "                    \"width\": 900\n" +
                "                }\n" +
                "            ],\n" +
                "            \"place_id\": \"ChIJSQWHOQDLkJQRujobHpv9uI8\",\n" +
                "            \"plus_code\": {\n" +
                "                \"compound_code\": \"3JV7+9W Vila Sanches, Andradina - State of São Paulo\",\n" +
                "                \"global_code\": \"58FC3JV7+9W\"\n" +
                "            },\n" +
                "            \"rating\": 4.6,\n" +
                "            \"reference\": \"ChIJSQWHOQDLkJQRujobHpv9uI8\",\n" +
                "            \"types\": [\n" +
                "                \"point_of_interest\",\n" +
                "                \"establishment\"\n" +
                "            ],\n" +
                "            \"user_ratings_total\": 5\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"OK\"\n" +
                "}"
        var jsonArray = JSONArray(retorno)
        for (jsonIndex in 0..(jsonArray.length() - 1)) {


            System.err.println("============" + jsonArray.getJSONObject(jsonIndex).getString("next_page_token")).toString()
        }
    }

}