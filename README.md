# Executando Vídeos

Projeto da disciplina **Aplicativos Mobile** — Etec Uirapuru
Professor: Fabio Claret

App Android nativo em **Java** que exibe os detalhes de um filme/série e
executa um vídeo local com controles de reprodução.

---

## Sobre o projeto

O app tem duas telas:

**1. Tela de detalhes (`MainActivity`)**
Mostra a capa, o título, a temporada, a classificação em estrelas e a sinopse.
No centro da capa fica o botão de play.

**2. Tela do player (`PlayerActivity`)**
Abre ao clicar no play. Trava na **orientação horizontal**, roda em **tela cheia**
(sem barra de status e sem barra de navegação) e exibe os controles de
**play, pause, avançar e retroceder**.

---

## Funcionalidades

- [x] Layout em `ConstraintLayout` com âncoras horizontais e verticais
- [x] `RatingBar` com 5 estrelas e classificação 4.5
- [x] Texto da sinopse justificado (`justificationMode="inter_word"`)
- [x] Navegação entre telas com `Intent`
- [x] Reprodução de vídeo local (`res/raw`) com `VideoView`
- [x] Controles do player com `MediaController`
- [x] Orientação travada em paisagem via `AndroidManifest`
- [x] Modo imersivo com `setSystemUiVisibility()`
- [x] Cor personalizada da barra de status pelo tema

---

## Estrutura

```
app/src/main/
├── AndroidManifest.xml
├── java/com/example/executando_videos_kayan/
│   ├── MainActivity.java       # tela de detalhes + clique no play
│   └── PlayerActivity.java     # player do vídeo
└── res/
    ├── drawable/
    │   ├── fundo.xml           # capa do filme
    │   └── play.xml            # botão de play
    ├── layout/
    │   ├── activity_main.xml
    │   └── activity_player.xml
    ├── raw/
    │   └── video.mp4           # vídeo executado pelo player
    └── values/
        ├── strings.xml
        └── themes.xml          # tema + statusBarColor
```

---

## Como o vídeo é executado

Três linhas na `PlayerActivity` resolvem a reprodução:

```java
// cria os controles: play, pause, avançar e retroceder
videoView.setMediaController(new MediaController(this));

// localiza o vídeo dentro da pasta raw usando o nome do pacote
videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);

// inicia a reprodução
videoView.start();
```

O caminho é montado com `getPackageName()` em vez do pacote digitado à mão,
então continua funcionando mesmo se o nome do pacote mudar.

---

## Tela cheia e orientação

A orientação é travada no `AndroidManifest.xml`:

```xml
<activity
    android:name=".PlayerActivity"
    android:exported="false"
    android:screenOrientation="landscape" />
```

E as barras do sistema são escondidas no `onWindowFocusChanged`, para ganhar
espaço de tela durante o vídeo:

```java
View decorView = getWindow().getDecorView();
decorView.setSystemUiVisibility(
        View.SYSTEM_UI_FLAG_FULLSCREEN
      | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
      | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
```

---

## Como rodar

1. Clone ou baixe o repositório.
2. Abra a pasta do projeto no **Android Studio** (`File > Open`).
3. Espere o Gradle sincronizar.
4. Rode com ▶ em um emulador ou celular com **Android 8.0 (API 26)** ou superior.

> A API 26 é necessária por causa do `justificationMode`, usado na sinopse.

---

## Tecnologias

| Item | Versão |
|---|---|
| Linguagem | Java |
| IDE | Android Studio |
| Pacote | `com.example.executando_videos_kayan` |
| Min SDK | 26 (Android 8.0 Oreo) |
| Layout | ConstraintLayout |
| Player | VideoView + MediaController |

---

## Sobre as imagens

A capa (`fundo.xml`) e o botão de play (`play.xml`) estão em `res/drawable`
como **XML vetorial**. Para trocar pelas suas imagens:

1. Copie `fundo.png` e `play.png` para `app/src/main/res/drawable`.
2. Apague `fundo.xml` e `play.xml` (senão os nomes conflitam).

Os layouts apontam para `@drawable/fundo` e `@drawable/play`, então não é
preciso mexer em mais nada.

---

## Habilidades adquiridas

- Executar um vídeo em um app Android
- Configurar um player com controles de reprodução
- Ocultar elementos da interface para ganhar espaço de tela
- Ancorar elementos em `ConstraintLayout`

---

**Kayan Denizo** · [GitHub](https://github.com/KayanDenizo)
