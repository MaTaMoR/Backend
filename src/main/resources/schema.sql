-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-05-2022 a las 11:24:38
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.4.27
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bookreview`
--

DROP DATABASE bookreview;
CREATE DATABASE bookreview;
USE bookreview;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autors`
--

CREATE TABLE `autors` (
                          `id` bigint(20) NOT NULL,
                          `image` varchar(255) DEFAULT NULL,
                          `name` varchar(64) DEFAULT NULL,
                          `surnames` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `autors`
--

INSERT INTO `autors` (`id`, `image`, `name`, `surnames`) VALUES
                                                             (1, NULL, 'Vi', 'Keeland'),
                                                             (9, NULL, 'Ali', 'Hazelwood'),
                                                             (13, NULL, 'Alissa', 'Brontë'),
                                                             (16, NULL, 'Raquel', 'Antúnez'),
                                                             (18, NULL, 'Whitney', 'G'),
                                                             (21, NULL, 'Yanira', 'García'),
                                                             (23, NULL, 'Lina', 'Galán'),
                                                             (26, NULL, 'Max', 'Monroe'),
                                                             (28, NULL, 'Elena', 'García'),
                                                             (31, NULL, 'Maria José', 'Tirado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `books`
--

CREATE TABLE `books` (
                         `id` bigint(20) NOT NULL,
                         `book_type` int(11) NOT NULL,
                         `description` varchar(5000) DEFAULT NULL,
                         `published_date` datetime(6) NOT NULL,
                         `title` varchar(64) DEFAULT NULL,
                         `total_pages` int(11) NOT NULL CHECK (`total_pages` >= 1),
                         `autor_id` bigint(20) NOT NULL,
                         `editorial_id` bigint(20) NOT NULL,
                         `image_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `books`
--

INSERT INTO `books` (`id`, `book_type`, `description`, `published_date`, `title`, `total_pages`, `autor_id`, `editorial_id`, `image_id`) VALUES
                                                                                                                                             (8, 0, 'Dos personas que aparentemente no deberían estar juntas descubren que sus vidas se vieron afectadas por un mismo suceso hace más de diez años.  La noche antes de que empiece el curso de sus estudios de posgrado, Rachel se encuentra en un bar al ex infiel de su mejor amiga y lo ataca verbalmente. El único error es que el chico en cuestión al que acaba de gritar –chico, por cierto, bastante atractivo– resulta que no es el ex de su mejor amiga.  A la mañana siguiente, al llegar tarde a su primer día como asistente universitaria en el posgrado, se da cuenta de que su nuevo jefe, el profesor, es el chico atractivo de la noche anterior.  Caine West es muy estricto con lo que respecta a las relaciones con sus estudiantes o con sus asistentes. Nunca se ha acostado con ninguna de ellas, hasta que conoce a Rachel. Ella hace que él desee romper todas sus reglas, incluso sabiendo que hay un secreto oculto en el pasado de ambos que los une y los cambiará para siempre.', '2022-02-10 00:00:00.000000', 'Un error maravilloso', 328, 1, 2, 1),
                                                                                                                                             (12, 0, 'Olive Smith es una doctoranda de tercer año que no cree en las relaciones amorosas duraderas, pero su mejor amiga, Ahn, sí, y por eso Olive se ha metido en un lío monumental. A Ahn le gusta el exnovio de Olive, pero jamás daría el primer paso porque es una buena amiga. A Olive no le va a resultar nada fácil convencerla de que ha pasado página, puesto que los científicos necesitan pruebas. Por eso, como cualquier mujer con un mínimo de amor propio, se deja llevar por el pánico y besa al primer hombre con el que se encuentra para que Ahn la vea.  Ese hombre es nada más y nada menos que Adam Carlsen, un joven profesor tan reputado por la calidad de su trabajo como por su imbecilidad. Así que Olive se queda de piedra cuando Carlsen accede a mantener su farsa en secreto y ser su novio falso. Sin embargo, después de que un importante congreso científico se convierta en un desastre y Adam vuelva a sorprenderla con su apoyo inquebrantable (y sus inquebrantables abdominales), su pequeño experimento se acerca peligrosamente al punto de combustión. Olive no tarda en descubrir que la única cosa más complicada que una hipótesis sobre el amor es analizar su propio corazón bajo el microscopio.', '2022-03-17 00:00:00.000000', 'La hipótesis del amor', 406, 9, 10, 2),
                                                                                                                                             (15, 0, 'La vida de Lola es un drama: un trabajo que la aburre, un desengaño amoroso que parece sacado de una película de terror y un despido envuelto en el escándalo, la dejarán sin saber qué hacer con su vida a la que, si tuviera que poner un título, bien podría ser: «Mi vida… ¡qué drama!». Por causalidad, descubre los K-dramas y serán estas series coreanas las que le ayudarán a olvidarse de su triste realidad. Pero el destino siempre guarda un as en la manga y el que ha reservado para Lola es una oferta de trabajo en Seúl. Emocionada y sin nada que perder, se embarcará en un viaje a Corea del Sur con la esperanza de pisar los lugares de los que se ha enamorado a través de la pantalla y, si tiene suerte, conocer a alguno de sus oppas favoritos. Aunque, no contaba con toparse con Hyo, que hará que todo resulte ser tan diferente de lo que imaginaba que su vida acabará pareciendo un K-drama.', '2021-09-20 00:00:00.000000', 'Mi vida K-Drama', 308, 13, 14, 3),
                                                                                                                                             (17, 1, 'Tengo un decálogo, un auténtico decálogo de razones por las que enamorarse no es una buena idea. Me lo repito como un mantra cada mañana, lo he memorizado, sí, porque es importante. Y enamorarme no quiero, pero, claro, hay otras cosas para las que sí que necesito a un hombre y me gustan más que a un tonto un lápiz; follar, básicamente, así que: Lea, cariño, cuidado con traspasar la línea. Todo iba cojonudamente bien hasta que conocí a Julien, el abogaducho ese que se cruzó en mi camino por culpa de mi mejor amiga. Desde el momento en que nos conocimos tuvimos una conexión especial, no tiene nada que ver con que él se viera amenazado, ligeramente, con un boli BIC a la altura de su cuello. En fin…, corramos un tupido velo. Que no, tío, que no, a mí no me pillas. El gato y el ratón, lo veo venir, ese será nuestro juego. Os pongo en escena; salgo del ascensor, estoy acostumbrado a este tipo de situaciones, pero esta vez es más desagradable porque Valentina es una buena tía, imagínate mi cara cuando me dirijo al rellano y me encuentro con una mujer, la mujer más jodidamente sexi que he visto en mi vida, amenazándome con un bolígrafo. Flipé, sí, pues anda que ese solo fue el comienzo, menuda tortura, cardíaco me pone, en todos los sentidos, no sé si terminaré muriendo de un infarto o qué. Lo mejor es que me olvide de ella, sí, eso es lo mejor. Venga, tía loca, déjame en paz. Y ya está, se acabó, chimpón, cada uno por su lado…, ¿o no?.', '2022-02-22 00:00:00.000000', 'Veinte motivos para olvidarte del amor', 278, 16, 14, 4),
                                                                                                                                             (20, 0, 'Penelope, sé que son las tres de la mañana, pero necesito quitarme este peso de encima. No puedo seguir dándote consejos sobre cómo conseguir a ese otro tipo, contarte más «cosas sexis» que podrías hacer ni sugerirte más frases subidas de tono para enviarle por mensaje por la noche. Como tu mejor amigo, he alcanzado mi límite, y, sinceramente, debo decir que no te merece. No te estoy diciendo todo esto porque esté celoso ni porque tuvo la cara dura de decir que ganaba más dinero que yo (por cierto: sigo sin poder encontrar su nombre en la lista Forbes 500, y sé de buena tinta que ha alquilado el Ferrari, pero esa historia te la contaré otro día). No es quien tú crees que es. Creo firmemente que estarías mucho mejor con otra persona, y necesito que lo compruebes por ti misma. El hombre perfecto ha estado siempre delante de tus narices… Tienes todos los motivos para no darme nunca una oportunidad, porque me conoces mejor que nadie, y porque además opinas lo mismo que los titulares de prensa que me llaman «el rey arrogante de Nueva York» o «el playboy ingobernable de Manhattan». No te estoy pidiendo demasiado… Solo quiero que rompas con él para estar conmigo.', '2021-10-25 00:00:00.000000', 'Te esperaré todas las noches', 385, 18, 19, 5),
                                                                                                                                             (22, 0, 'Lo de empezar contándoos lo patética que es mi vida como que no es una buena carta de presentación, ¿verdad? Y deciros que sigo cargando el lastre de mi ex porque no soy capaz de afrontar la situación tampoco está contemplado, ¿cierto? Espera, espera, ¿y lo de que trabajo en una línea erótica porque necesito el dinero para ayudar a mi hermana con sus estudios ya que mi madre se fue a vivir la vida loca? Ah, que tengo más, tranquila… ¿Os cuento ya que Bruno, mi jefe, me ha encomendado una tarea como publicista que odio y no solo eso, que me produce repulsión absoluta? ¿Y que en el proceso de esa campaña publicitaria (insisto, que odio) la relación entre mi jefe y yo deja de ser solo profesional? Suena heavy, ¿a que sí? Y luego está Ferran, que es un imbécil, eso mejor me lo callo, ¿no? Y lo de mi hermana y nuestro compañero de piso, ¿os lo explico? ¿Y lo de mi amiga Aina? Porque ese es otro cacao. En fin, que si creéis que vuestra vida es un embrollo constante es porque aún no me conocéis. Me llamo Violeta, o Lilah, ¿y tú eres…? O quizá prefieras contarme qué llevas puesto….', '2022-02-05 00:00:00.000000', 'Línea erótica, ¿dígame?', 436, 21, 14, 6),
                                                                                                                                             (25, 4, 'Imagina que, mientras caminas por la Séptima Avenida, ves a tu exnovio y tu examiga cenando juntos en tu restaurante favorito.  Imagina que, en ese momento, recuerdas cómo tu prometido te plantó una semana antes de la boda porque había dejado embarazada a otra mujer, que, para más inri, era tu amiga.  Imagina que te pones a llorar y, de la rabia, todo el contenido de tu bolso acaba desparramado por la acera.  Imagina que, de pronto, un desconocido con pinta de modelo de anuncio se agacha a tu lado y te ayuda a recoger tus cosas. Y te mira, con sus increíbles ojos azules; te sonríe, con sus tentadores labios; te deslumbra, con su brillante cabello dorado.  Pues no imagines más, porque, en esta historia, comprobarás que todo eso le ocurre a Abbey, quien, en un difícil momento de su vida, conoce a Nathan, un hombre tan atractivo como encantador, tan irresistible como fascinante.  Abbey no acaba de creerse que un hombre así pueda estar interesado en ella. Y puede, incluso, que le resulte demasiado perfecto…', '2021-10-14 00:00:00.000000', 'Demasiado perfecto', 419, 23, 24, 7),
                                                                                                                                             (27, 0, 'Georgia Cummings no tiene suerte con las citas, y no importa lo mucho que lo intente, no es capaz de encontrarle la gracia a ese extraño universo alternativo donde los hombres piensan que enviarle la foto de un pene es el equivalente a mantener una conversación para conocer a una mujer. Como vea un selfie de esos más, renunciará a escribir a los tíos para siempre. Kline Brooks parece el chico malo por excelencia: pelo oscuro, corto y bien peinado, músculos de acero y una sonrisa que te vuelve loca. Y por si eso no fuera suficiente, es billonario. Y el jefe de Georgia… Así que, dado que ella es su empleada, a él no se le ocurrirá nunca acercarse a ella. Ni ella debería hacerlo si tuviera dos dedos de frente. Pero ¿por qué Georgia no puede dejar de fantasear con él? Lástima que sus hormonas vayan por libre…', '2021-08-30 00:00:00.000000', 'El billonario', 370, 26, 19, 8),
                                                                                                                                             (30, 0, 'La vida de Mariajo es tan anodina, que incluso aburre a los aburridos. Sin embargo, la visita de un hombre impresionante a su farmacia, en la que ella queda en evidencia de la peor de las maneras, producirá un cambio radical en su rutina, sobre todo, cuando este le revela lo que quiere comprar.  Mientras que su trabajo peligra, por circunstancias que no logra entender, vivirá junto a este misterioso hombre, cientos de disparatadas situaciones en las que, además de averiguar a qué se dedica realmente, comprenderá que, la prepotencia inicial con la que ha estado tratándola no es tal, sino que encierra en su interior mucho más que sus ganas de molestarla.', '2021-08-19 00:00:00.000000', 'La manguera que nos unió', 346, 28, 29, 9),
                                                                                                                                             (32, 0, 'Sara Celona tiene dos hijos y está divorciada del que fue su primer y único novio, ya no cree en el amor y piensa que nada ni nadie podrá sorprenderla. Se equivoca.  Cuando recibe una llamada telefónica desde un hospital en Turquía advirtiéndole de que su padre, al que no conoce, ha sufrido complicaciones después de un trasplante capilar, no puede creer que deba viajar a Estambul para autorizar una intervención que podría salvarle la vida.  Allí se topará de bruces con una cultura desconocida y, sobre todo, tendrá que aprender a lidiar con el doctor Aslan Kaya, un neurocirujano turco tan atractivo como insoportable. Junto a él tratará de recomponer los pedazos de una parte desconocida de sí misma mientras intenta evitar por todos los medios enamorarse de él.  Descubre una divertida aventura repleta de personajes irreverentes y mucho amor.  ¿Podrás resistirte al doctor Kaya?', '2021-10-14 00:00:00.000000', 'Mi propio turco de telenovela', 550, 31, 14, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `books_categories`
--

CREATE TABLE `books_categories` (
                                    `book_id` bigint(20) NOT NULL,
                                    `categories_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `books_categories`
--

INSERT INTO `books_categories` (`book_id`, `categories_id`) VALUES
                                                                (8, 3),
                                                                (8, 4),
                                                                (8, 5),
                                                                (8, 6),
                                                                (8, 7),
                                                                (12, 3),
                                                                (12, 4),
                                                                (12, 7),
                                                                (12, 6),
                                                                (12, 11),
                                                                (15, 3),
                                                                (15, 4),
                                                                (15, 5),
                                                                (15, 6),
                                                                (15, 7),
                                                                (17, 3),
                                                                (17, 4),
                                                                (17, 5),
                                                                (17, 6),
                                                                (17, 7),
                                                                (20, 3),
                                                                (20, 4),
                                                                (20, 5),
                                                                (20, 6),
                                                                (20, 7),
                                                                (22, 3),
                                                                (22, 4),
                                                                (22, 5),
                                                                (22, 6),
                                                                (22, 7),
                                                                (25, 3),
                                                                (25, 4),
                                                                (25, 5),
                                                                (25, 6),
                                                                (25, 7),
                                                                (27, 3),
                                                                (27, 4),
                                                                (27, 5),
                                                                (27, 6),
                                                                (27, 7),
                                                                (30, 3),
                                                                (30, 4),
                                                                (30, 5),
                                                                (30, 6),
                                                                (30, 7),
                                                                (32, 3),
                                                                (32, 4),
                                                                (32, 5),
                                                                (32, 6),
                                                                (32, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `books_likes`
--

CREATE TABLE `books_likes` (
                               `book_id` bigint(20) NOT NULL,
                               `likes_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `books_series`
--

CREATE TABLE `books_series` (
                                `id` bigint(20) NOT NULL,
                                `nombre` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categories`
--

CREATE TABLE `categories` (
                              `id` bigint(20) NOT NULL,
                              `name` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
                                            (3, 'Novela'),
                                            (4, 'Romance'),
                                            (5, 'Erotico'),
                                            (6, 'Contemporaneo'),
                                            (7, 'Comedia'),
                                            (11, 'Enemies to lovers');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editorials`
--

CREATE TABLE `editorials` (
                              `id` bigint(20) NOT NULL,
                              `name` varchar(64) DEFAULT NULL,
                              `image_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `editorials`
--

INSERT INTO `editorials` (`id`, `name`, `image_id`) VALUES
                                                        (2, 'Roca Editorial', 22),
                                                        (10, 'Contraluz', 23),
                                                        (14, 'Autopublicado', 24),
                                                        (19, 'Phoebe', 25),
                                                        (24, 'Zafiro', 26),
                                                        (29, 'Nova Casa', 27);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
                                      `next_not_cached_value` bigint(21) NOT NULL,
                                      `minimum_value` bigint(21) NOT NULL,
                                      `maximum_value` bigint(21) NOT NULL,
                                      `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
                                      `increment` bigint(21) NOT NULL COMMENT 'increment value',
                                      `cache_size` bigint(21) UNSIGNED NOT NULL,
                                      `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
                                      `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
    (1001, 1, 9223372036854775806, 1, 1, 1000, 0, 0);
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `img`
--

CREATE TABLE `img` (
                       `id` bigint(20) NOT NULL,
                       `name` varchar(255) DEFAULT NULL,
                       `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `img`
--

INSERT INTO `img` (`id`, `name`, `type`) VALUES
                                             (1, 'un_error_maravilloso.png', 'image/png'),
                                             (2, 'la_hip_tesis_del_amor.png', 'image/png'),
                                             (3, 'mi_vida_k_drama.png', 'image/png'),
                                             (4, 'veinte_motivos_para_olvidarte_del_amor.png', 'image/png'),
                                             (5, 'te_esperar__todas_las_noches.png', 'image/png'),
                                             (6, 'l_nea_er_tica___d_game_.png', 'image/png'),
                                             (7, 'demasiado_perfecto.png', 'image/png'),
                                             (8, 'el_billonario.png', 'image/png'),
                                             (9, 'la_manguera_que_nos_uni_.png', 'image/png'),
                                             (10, 'mi_propio_turco_de_telenovela.png', 'image/png'),
                                             (11, 'un_error_maravilloso.png', 'image/png'),
                                             (12, 'la_hip_tesis_del_amor.png', 'image/png'),
                                             (13, 'mi_vida_k_drama.png', 'image/png'),
                                             (14, 'veinte_motivos_para_olvidarte_del_amor.png', 'image/png'),
                                             (15, 'te_esperar__todas_las_noches.png', 'image/png'),
                                             (16, 'l_nea_er_tica___d_game_.png', 'image/png'),
                                             (17, 'demasiado_perfecto.png', 'image/png'),
                                             (18, 'el_billonario.png', 'image/png'),
                                             (19, 'la_manguera_que_nos_uni_.png', 'image/png'),
                                             (20, 'mi_propio_turco_de_telenovela.png', 'image/png'),
                                             (21, '11260637.jpg', 'image/jpeg'),
                                             (22, 'roca_editorial.png', 'image/png'),
                                             (23, 'contraluz.png', 'image/png'),
                                             (24, 'autopublicado.png', 'image/png'),
                                             (25, 'phoebe.png', 'image/png'),
                                             (26, 'zafiro.png', 'image/png'),
                                             (27, 'nova_casa.png', 'image/png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `likes`
--

CREATE TABLE `likes` (
                         `id` bigint(20) NOT NULL,
                         `book_id` bigint(20) DEFAULT NULL,
                         `date` datetime(6) DEFAULT NULL,
                         `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `privileges`
--

CREATE TABLE `privileges` (
                              `id` bigint(20) NOT NULL,
                              `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `privileges`
--

INSERT INTO `privileges` (`id`, `name`) VALUES
    (1, 'EDIT');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reviews`
--

CREATE TABLE `reviews` (
                           `id` bigint(20) NOT NULL,
                           `review` varchar(10000) DEFAULT NULL,
                           `review_date` datetime(6) DEFAULT NULL,
                           `score` int(11) DEFAULT NULL CHECK (`score` >= 1 and `score` <= 5),
                           `autor_id` bigint(20) NOT NULL,
                           `book_id` bigint(20) NOT NULL,
                           `image_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reviews`
--

INSERT INTO `reviews` (`id`, `review`, `review_date`, `score`, `autor_id`, `book_id`, `image_id`) VALUES
                                                                                                      (33, 'Todos tienen un pasado que se desea olvidar, un pasado del que nadie quiere hablar, un pasado del qué se pretende de que nunca existió. Hasta que por casualidades de la vida, todo lo que intentabas dejar atrás vuelve a ti para hurgar tu presente.  Dos personas que se conocen frente a frente en un presente, dos personas que sin saberlo compartieron un pasado, dos personas que compartieron un mismo recuerdo de hace mucho tiempo. Un encuentro entre dos personas que nunca pasó por casualidad.  Aunque se cometieron muchos errores en el pasado, no todos los errores son malos, porque el haberse conocido por un error o una coincidencia de espacio y tiempo será la coincidencia más maravillosa que Caine y Rachel compartirán. Porque los errores nunca pasan en vano y ambos se darán cuenta de que reencontrarse es el mejor regalo que el pasado pudo darles', '2022-05-26 12:37:02.47800', 4, 1, 8, 11),
                                                                                                      (34, '¿Qué es el amor para la ciencia? Si le preguntas a un par de científicos podrían decirte, que el amor se define como un proceso neurológico que se produce en tu cerebro.   Es decir que cuando escuchas hablar de las famosas mariposas que revolotean en tu estómago o esa sensación de que tu propio corazón se sale del pecho, es una vil mentira, todo es debido a un cierto proceso químico de tu cabeza, nada más.   Y claro, como todo lo que rige en la vida de Olive, absolutamente todo tiene que ser sustentado por la ciencia, porque obviamente, ¿que sería de los científicos sin sus propias hipótesis?  Sin embargo, Olive no puede pasar por alto que un científico no debe olvidar que una hipótesis debe considerarse como un medio, jamás como un fin.  Porque así como una hipótesis puede que sea cierta o no, tal vez el amor sí sea científicamente hablando una liberación de hormonas del cerebro, pero hay algo más, tal vez es que el amor sea libertad y no puede ser regido por ninguna fórmula, por muy compleja que sea.   Una doctoranda y un reputado profesor que viven por y para la ciencia, dos científicos que pondrán en duda todas sus teorías porque si es cierto que la ley de la atracción no tiene fundamento científico, la realidad es que lo que se supone que esté surgiendo entre ellos se convertirá en algo más que en un experimento. Porque sus encuentros son cómo el contacto de dos sustancias químicas: si hay reacción, ambas podrían transformarse.', '2022-05-26 12:37:02.47800', 4, 1, 12, 12),
                                                                                                      (35, 'Una decepción amorosa y muy desastrosa hará que Lola decida reemplantearse el rumbo de su vida, siendo los dramas coreanos la cura para un corazón roto. Es bien dicho que las oportunidades son como los amaneceres, si uno espera demasiado puedes llegar a perdértelos. Es por eso que sin esperarlo, el destino le dará una oportunidad tan tentadora que a la que no podría negarse ni viviendo cien vidas. Será su prima quien la saque de esa atmósfera post-ruptura y le pida emprender un viaje que cambiará su vida.  Es por eso que sin pensarlo dos veces, decide poner tierra y muchos kilómetros de por medio e irse a conocer en primera persona a los guapos y sexys protagonistas de sus dramas coreanos. Esos con los que sueña llamar \'Oppa\'y que la ponga mirando a Gangman.  Será su naturalidad tan espontánea de siempre disfrutar del momento y una lista de deseos hecha mano con todo lo que hará durante su estadía en Corea que pondrá de patas arriba el mundo del próximo bombón coreano.  Porque no solo será el ramen, ni emborracharse tomando soju, ni tampoco visitar los lugares más emblemáticos del lugar, enamorarse no hacía parte de sus planes y no se equivoca que esto podría llevarla a que su vida termine como un autentico K-drama y serán Hyo y Lola los protagonistas del próximo drama coreano, uno que pasa en la vida real.  Una historia donde dos personas de mundos tan diferentes se juntan para colisionar, una historia llena de romance, de risas y refrescante que puede enseñarte que a veces lo que llegues a imaginar con el corazón es probable que sí llegue a suceder.', '2022-05-26 12:37:02.47800', 3, 1, 15, 13),
                                                                                                      (36, 'La mayoría de los seres humanos intentan encontrar el amor y una otra vez de cualquier forma, pueden llegar a hacer hasta lo imposible para encontrar ese complemento que tanto les hacia falta pero que aun no lo sabían. Puede que hasta ese sentimiento que llamen amor sea tan perjudicial para tu salud mental y física. En definitiva, caer en las redes del amor no es para todo el mundo y mucho menos para ella.   Para Lea, sus razones para no enamorarse es tan importante e inquebrantable como los propios diez mandamientos, es por eso que cada día las repite como sí de su propio mantra se tratase. Ella, ¿buscar su media naranja? absolutamente ’NO’ ya que este mundo está repleto de medios limones. Pero sobre todo, y lo más alucinante de todo, es que si llegas a enamorarte, dile adiós a tu capacidad de raciocinio. En definitiva, Lea no tiene ningún interés en caer en semejante trampa.   Pero el destino es caprichoso y no le valdrá sus veinte motivos para olvidarse del amor, porque lo que está destinado a pasar no se puede evitar a que suceda, siendo él quien le demuestre más de veinte motivos por los que si se le debe dar una oportunidad al amor.', '2022-05-26 12:37:02.47800', 3, 1, 17, 14),
                                                                                                      (37, 'Penelope y Hayden se conocen desde hace muchísimo tiempo, ella era la ‘hermana pesada’ de su mejor amiga y él un ‘cabrón arrogante’ que ha tenido la mala suerte de conocer. Por donde se le vea no podría haber mas desprecio entre ambos hasta que esos sentimientos de odio empiezan a desvanecerse. Dicen que el tiempo cambian las cosas pero en realidad serán ellos que pondrán fin a esa guerra fría que se declararon años atrás.   Para ella, Hayden no solo es su mejor amigo sino que se ha ganado con creces el puesto del hermano mayor y es la razón por la que se toma cada uno de sus consejos al pie de la letra. Para él, Penelope es más que su mejor amiga, se ha convertido en su única familia y lo único que desea es que encuentre alguien que verdaderamente la merezca.   Pero, ¿cómo podrías decirle a tu mejor amiga que el hombre perfecto se encuentra justamente al frente de ella?, ¿cómo podrías decirle que nadie la amará y la hará feliz tanto como tú?. Porque ella te conoce tan bien que sabe que a ti solo te van los rollos de una noche y le huyes como la peste a cualquier relación.   Pero si hay algo que defina a Hayden Hunter no es su arrogancia sino su persistencia y le hará ver de todos los beneficios que existen de tener una relación amorosa con tu mejor amigo. Porque no existe amistad sin amor y no hay nada más ideal que ser.', '2022-05-26 12:37:02.47800', 4, 1, 20, 15),
                                                                                                      (38, 'Se dice que no se debe vivir en el pasado ya que es posible que te pierdas de las grandes cosas que puedan sucederte en el presente. El decirlo suena muy sencillo pero llevarlo a cabo es lo complicado. Porque, ¿cómo puedes hacerle frente si aún te lo recuerdan?   Violeta es la chica de la sonrisa, la chica de los colores, la chica que huele a arándanos, la misma chica que antepone sus intereses propios por los de los demás, la chica que desea que todos sean muy felices, la misma Violeta que ha dejado de brillar con su luz propia. Porque a pesar que su colores se han ido apagando hasta hacerla invisible, para él, ella siempre ha existido y hará hasta lo imposible para que ella también lo crea.   Una historia adictiva que te dará el impulso de volver a creer en ti misma, una historia que nos enseña que para superar el pasado, lo primero es aceptarlo porque no importa las veces que lo vuelvas a pensar ni las veces que te arrepientas. Porque todo lo malo que viviste te han dado experiencia y los peores momentos te han enseñado a vivir.', '2022-05-26 12:37:02.47800', 3, 1, 22, 16),
                                                                                                      (39, 'Ninguna vida puede considerarse perfecta, pero para Abbey, es como si estuviera pagando los karmas de todos sus antepasados y esto es debido a una serie de infortunios que parece que se convirtieran peor que el anterior. Nathan es la perfección andante. No solo es su físico que atrae las miradas de las mujeres y la envidia de los hombres, sino su éxito profesional. Todo lo que se propone lo logra, pero ¿hasta dónde estaría dispuesto a llegar para conseguir sus objetivos?   Ya es difícil intentar sobrellevar la situación de un corazón roto de Abbey pero como las desgracias nunca llegan solas, de todos los lugares de la ciudad de Nueva York como es posible que coincidiera con quienes la traicionaron y para ponerle más limón a la herida que se vean tal felices juntos, es como si ella nunca hubiera existido. En definitiva su día no puede ir para peor, pero bien dicen que en medio de la tormenta viene la calma y será Nathan quien le ayudará un poco a salir de tan penosa situación. Lo que ella nunca se imaginó es que el remedio fuera peor que la enfermedad y se encuentre con que sea él que le pida una cita en condiciones.   Obviamente después de semejante chasco amoroso su cuota de hombres ha llegado a su fin y lo que menos que desea es volver a sufrir por amor, pero como es posible que sin que lo esperara, tenerlo cerca hace que se forme un huracán en medio de su corazón y sus piernas, porque es imposible que alguien como él pueda estar interesado en alguien como ella. ¿Será posible que un playboy y una chica que ya no cree en el felices para siempre puedan estar juntos?   Una historia que demuestra que los sentimientos que se sienten con el corazón son perfectos, porque cuando tu corazón se enamora de verdad es cuando aprendes que todas esas imperfecciones se convierten en perfectas para ti. ', '2022-05-26 12:37:02.47800', 4, 1, 25, 17),
                                                                                                      (40, 'Georgia Cummings puede definirse a sí misma como una mujer exitosa en el ámbito laboral, sin embargo, esa suerte la abandonó en lo que al amor se refería. Es por eso que simplemente plantearse en tener una cita ya es para ella un grave problema. Pero todo esto cambia cuando por políticas de la empresa todos los empleados sin pareja debían crearse un perfil en una aplicación de citas.   Kline Brooks es uno de los millonarios más cotizados de Nueva York, siendo el CEO de Brooks Media. No era el típico jefe malhumorado ni que gobernaba con puño de hierro, al contrario, siempre mantenía una sonrisa muy cordial para todos sus empleados. Ese era el secreto de sus billones, que sus colaboradores estén en un buen ambiente laboral.   Pero el mundo es pequeño y dicha política de la empresa que debe ser acatada tanto por empleados como el mismo CEO será el inicio de esta historia. Porque dicen que los negocios y el placer no se mezclan, pero lo que no saben es cómo negociar. Porque Kline Brooks ha llegado a la cima por su poder de negociación y ahora lo que mas desea en la vida es que ella sea parte del contrato. ', '2022-05-26 12:37:02.47800', 4, 1, 27, 18),
                                                                                                      (41, 'La vida de Mariajo puede definirse como monótona y hasta sosa. Sus días transcurren en atender su propio negocio y en recibir a sus clientes habituales con la receta médica para la presión alta, gotas oculares, entre otras cosas. No obstante, lo que sería un día como cualquier otro cambiará radicalmente con la visita de un nuevo cliente que de habitual no tiene nada. No solo por la edad del implicado sino por lo que le pedirá a la mojigata dueña, una caja de preservativos y de tamaño descomunal.   Este será el inicio de esta ocurrente historia, donde las risas y los enredos están a la orden del día. Una historia que te enseñará que de lo malo que pueda pasar se aprenden también cosas buenas, porque será un desconocido quien ayudará a Mariajo a ver lo simple y fácil que puede ser la vida a como disfrutar de lo que el día a día puede ofrecerte. Porque en lo simple se encuentra un abrazo, un beso inesperado, un te quiero dicho de distintas maneras. Porque en la simplicidad está la clave de ser feliz.', '2022-05-26 12:37:02.47800', 4, 1, 30, 19),
                                                                                                      (42, 'Que niña no soñaba con encontrar su final de cuento de hadas, un príncipe que te protegiera de brujas y dragones. Obviamente las ilusiones que se tenían en la infancia no son las mismas que se tienen en la vida adulta y eso lo sabe muy bien Sara, una mujer que no cree en príncipes ni mucho menos en el amor.   Porque nunca se debe dar nada por sentado; ya que todo puede cambiar, y todo puede comenzar, es como la vida de Sara termine dando un giro de 180 grados cuando deba dejar su tranquilo mundo para hacer un viaje express a la tierra de la mil y unas noches, Estambul. Porque nadie la iba a preparar para lo que iba a suceder y que llegara a tu vida un príncipe en forma de médico cuando ya tienes un divorcio a cuestas, es algo que no pasaría en esas telenovelas turcas que tanto ven tus mejores amigas.   Una historia que nos demuestra que nunca es tarde ni temprano para amar porque el amor es cuestión de almas y las almas no tienen edad. Una historia con un príncipe de protagonista bastante insoportable pero irresistible para ella. Una historia con un hombre que la ayudará a buscar eso que perdió en el camino pero que aún no lo sabe. Una historia que te enseñará que si pudiste amar tanto a la persona equivocada, imagina cuánto podrás amar a la correcta.  ', '2022-05-26 12:37:02.47800', 3, 1, 32, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reviews_likes`
--

CREATE TABLE `reviews_likes` (
                                 `review_id` bigint(20) NOT NULL,
                                 `likes_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE `role` (
                        `id` bigint(20) NOT NULL,
                        `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
                                      (1, 'ADMIN'),
                                      (2, 'USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles_privileges`
--

CREATE TABLE `roles_privileges` (
                                    `role_id` bigint(20) NOT NULL,
                                    `privilege_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `roles_privileges`
--

INSERT INTO `roles_privileges` (`role_id`, `privilege_id`) VALUES
    (1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
                         `id` bigint(20) NOT NULL,
                         `avatar` varchar(255) DEFAULT NULL,
                         `email` varchar(255) DEFAULT NULL,
                         `name` varchar(16) DEFAULT NULL,
                         `password` varchar(255) DEFAULT NULL,
                         `register_date` datetime(6) DEFAULT NULL,
                         `surnames` varchar(32) DEFAULT NULL,
                         `username` varchar(16) DEFAULT NULL,
                         `image_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `avatar`, `email`, `name`, `password`, `register_date`, `surnames`, `username`, `image_id`) VALUES
    (1, '', 'matamor98@hotmail.com', 'Santiago', '$2a$10$mVE8RhCrE6sOvOGF2kpOK.wMF2e7RSwmxOqoii/LXhDqMZ6pPtLiu', '2022-05-26 12:37:02.47800', 'González Londoño', 'matamor', 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users_roles`
--

CREATE TABLE `users_roles` (
                               `user_id` bigint(20) NOT NULL,
                               `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
    (1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autors`
--
ALTER TABLE `autors`
    ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `books`
--
ALTER TABLE `books`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FKmtd7bwn7dqygs1aag84gt182x` (`autor_id`),
    ADD KEY `FK5sc7k405j33t6hxwoj107c300` (`editorial_id`),
    ADD KEY `FKijgt5fwcv7ock42j2n924b5q0` (`image_id`);

--
-- Indices de la tabla `books_categories`
--
ALTER TABLE `books_categories`
    ADD KEY `FKass1i2uq846riwn5tihbgsi0o` (`categories_id`),
    ADD KEY `FKmsuoucvyyccli3f6u59co41cq` (`book_id`);

--
-- Indices de la tabla `books_likes`
--
ALTER TABLE `books_likes`
    ADD UNIQUE KEY `UK_idlo4uk0vinbtlr36le2nv895` (`likes_id`),
    ADD KEY `FKg6ljgxckbb22jkje8aiknu432` (`book_id`);

--
-- Indices de la tabla `books_series`
--
ALTER TABLE `books_series`
    ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `categories`
--
ALTER TABLE `categories`
    ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `editorials`
--
ALTER TABLE `editorials`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FK6c1ttnoybw6lhvsm3w1a284b` (`image_id`);

--
-- Indices de la tabla `img`
--
ALTER TABLE `img`
    ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `likes`
--
ALTER TABLE `likes`
    ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `privileges`
--
ALTER TABLE `privileges`
    ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reviews`
--
ALTER TABLE `reviews`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FKq4wcsh5twso16f8r2ou333bul` (`autor_id`),
    ADD KEY `FK6a9k6xvev80se5rreqvuqr7f9` (`book_id`),
    ADD KEY `FKaa9tsj5cxislq6w7asmqbudlk` (`image_id`);

--
-- Indices de la tabla `reviews_likes`
--
ALTER TABLE `reviews_likes`
    ADD UNIQUE KEY `UK_ak8u0mlli2xm0ktwnxjpmqlw0` (`likes_id`),
    ADD KEY `FK8856ncj6vv72f8m9ojbayjsqk` (`review_id`);

--
-- Indices de la tabla `role`
--
ALTER TABLE `role`
    ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `roles_privileges`
--
ALTER TABLE `roles_privileges`
    ADD KEY `FK5duhoc7rwt8h06avv41o41cfy` (`privilege_id`),
    ADD KEY `FK9h2vewsqh8luhfq71xokh4who` (`role_id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FKradtaxp7cbhu89x72xoxct8xi` (`image_id`);

--
-- Indices de la tabla `users_roles`
--
ALTER TABLE `users_roles`
    ADD KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
    ADD KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`);

--
-- IDENTITY_INCREMENT de las tablas volcadas
--

--
-- IDENTITY_INCREMENT de la tabla `editorials`
--
ALTER TABLE `editorials`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- IDENTITY_INCREMENT de la tabla `img`
--
ALTER TABLE `img`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- IDENTITY_INCREMENT de la tabla `likes`
--
ALTER TABLE `likes`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- IDENTITY_INCREMENT de la tabla `privileges`
--
ALTER TABLE `privileges`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- IDENTITY_INCREMENT de la tabla `role`
--
ALTER TABLE `role`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- IDENTITY_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `books`
--
ALTER TABLE `books`
    ADD CONSTRAINT `FK5sc7k405j33t6hxwoj107c300` FOREIGN KEY (`editorial_id`) REFERENCES `editorials` (`id`),
    ADD CONSTRAINT `FKijgt5fwcv7ock42j2n924b5q0` FOREIGN KEY (`image_id`) REFERENCES `img` (`id`),
    ADD CONSTRAINT `FKmtd7bwn7dqygs1aag84gt182x` FOREIGN KEY (`autor_id`) REFERENCES `autors` (`id`);

--
-- Filtros para la tabla `books_categories`
--
ALTER TABLE `books_categories`
    ADD CONSTRAINT `FKass1i2uq846riwn5tihbgsi0o` FOREIGN KEY (`categories_id`) REFERENCES `categories` (`id`),
    ADD CONSTRAINT `FKmsuoucvyyccli3f6u59co41cq` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`);

--
-- Filtros para la tabla `books_likes`
--
ALTER TABLE `books_likes`
    ADD CONSTRAINT `FK9l3v879lwbaadimk79ccvp07s` FOREIGN KEY (`likes_id`) REFERENCES `likes` (`id`),
    ADD CONSTRAINT `FKg6ljgxckbb22jkje8aiknu432` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`);

--
-- Filtros para la tabla `reviews`
--
ALTER TABLE `reviews`
    ADD CONSTRAINT `FK6a9k6xvev80se5rreqvuqr7f9` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
    ADD CONSTRAINT `FKaa9tsj5cxislq6w7asmqbudlk` FOREIGN KEY (`image_id`) REFERENCES `img` (`id`),
    ADD CONSTRAINT `FKq4wcsh5twso16f8r2ou333bul` FOREIGN KEY (`autor_id`) REFERENCES `users` (`id`);

--
-- Filtros para la tabla `reviews_likes`
--
ALTER TABLE `reviews_likes`
    ADD CONSTRAINT `FK8856ncj6vv72f8m9ojbayjsqk` FOREIGN KEY (`review_id`) REFERENCES `reviews` (`id`),
    ADD CONSTRAINT `FKo4mwmdcyl9vylaaa4jgykfk7` FOREIGN KEY (`likes_id`) REFERENCES `likes` (`id`);

--
-- Filtros para la tabla `roles_privileges`
--
ALTER TABLE `roles_privileges`
    ADD CONSTRAINT `FK5duhoc7rwt8h06avv41o41cfy` FOREIGN KEY (`privilege_id`) REFERENCES `privileges` (`id`),
    ADD CONSTRAINT `FK9h2vewsqh8luhfq71xokh4who` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- Filtros para la tabla `users`
--
ALTER TABLE `users`
    ADD CONSTRAINT `FKradtaxp7cbhu89x72xoxct8xi` FOREIGN KEY (`image_id`) REFERENCES `img` (`id`);

--
-- Filtros para la tabla `users_roles`
--
ALTER TABLE `users_roles`
    ADD CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    ADD CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
