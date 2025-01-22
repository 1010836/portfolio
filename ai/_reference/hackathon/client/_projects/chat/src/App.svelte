<style global>

  @tailwind base;
  @tailwind components;
  @tailwind utilities;

  :root {
    --cyan-100: 183 90% 90%;
    --cyan-200: 183 90% 80%;
    --cyan-300: 183 90% 70%;
    --cyan-400: 183 90% 60%;
    --cyan-500: 183 90% 50%;
    --cyan-600: 183 90% 40%;
    --cyan-700: 183 90% 30%;
    --cyan-800: 183 90% 20%;
    --cyan-900: 183 90% 10%;
  }

  .background {
    position: fixed;
    width: 100%;
    height: 100%;
    left: 0;
    top: 0;
    z-index: 0;
    background-image:url("/background.png");
    background-position: inherit;
    background-repeat: no-repeat;
    background-size: cover; 
  }

  .main {

    position:fixed;
    bottom:84px;
    right:20px;
    height:70%;
    width:50%;
    
    border: none;
    
    font-family: "Segoe UI", "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
    font-feature-settings: normal;
    font-variation-settings: normal;
    font-size: 16px;
    line-height: 1;

    z-index: 10000;
  } 

  .main_div_third {
    border-radius: 8px;
  }

  .main_section {
    padding-bottom: 8px;
    padding-top: 8px;
    column-gap: 8px;
    row-gap: 8px;
  }
  
  .main_div_fourth {
    
    padding-left: 8px;
    padding-right: 8px;

    column-gap: 8px;
    row-gap: 8px;

  }

  .main_div_fifth {
    
    padding-top: 8px;
    padding-bottom: 8px;
    padding-left: 8px;
    padding-right: 8px;

    border-bottom-left-radius: 6px;
    border-bottom-right-radius: 6px;
    border-top-left-radius: 6px;

    column-gap: 8px;
    row-gap: 8px;

  } 

  .main_div_sixth {
    column-gap: 8px;
    row-gap: 8px;
  }
  
  .main_div_reset {
    padding-bottom: 7.5px;
    padding-left: 7.5px;
    padding-right: 7.5px;
    padding-top: 7.5px;
  }

  .main_div_reset p {
    all: unset;
  }

  /* width */
  ::-webkit-scrollbar {
    width: 10px;
  }

  /* Track */
  ::-webkit-scrollbar-track {
    background: #f1f1f1; 
  }
  
  /* Handle */
  ::-webkit-scrollbar-thumb {
    background: #888; 
  }

  /* Handle on hover */
  ::-webkit-scrollbar-thumb:hover {
    background: #555; 
  }
</style>

<script lang="ts">

  //#region 1. imports
  
    //#region 1.1 svelte
    import { onMount, afterUpdate } from 'svelte';
    import { createEventDispatcher } from 'svelte';
    import { object_without_properties } from 'svelte/internal';
    //#endregion

    //#region 1.2 components
    import Loader from './lib/components/Icons/Loader.svelte';
    import EntryModal from './lib/components/EntryModal.svelte';
    import FAQs from './lib/components/chat/FAQs.svelte';
    import Messages from './lib/components/chat/Messages.svelte';
    import Input from './lib/components/Input.svelte';
    import OpenCloseButton from './lib/components/chat/OpenCloseButton.svelte';
    import Send from './lib/components/Icons/Send.svelte';
    //#endregion

    //#region 1.3 stores
    import { chatMessages, answer } from './lib/stores/chat-messages';
    //#endregion

        
  //#endregion

  //#region 2. environment

  const __myapp = {
    env: environment
  };
  
  const QuestionIntro = __myapp.env.VITE_QUESTION_CTX_INTRO;
  const QuestionText = __myapp.env.VITE_QUESTION_CTX_TEXT;
  const QuestionTextEnd = __myapp.env.VITE_QUESTION_CTX_TEXTEND;
  const ThumbUpMessage = __myapp.env.VITE_USER_THUMB_UP;
  const ThumbDownMessage = __myapp.env.VITE_USER_THUMB_DOWN;
  const UrlToHumanChat = __myapp.env.VITE_HUMAN_CHAT_URL;
  const HumanChatOption = __myapp.env.VITE_HUMAN_CHAT_OPT;
  const ServiceErrorMsg = __myapp.env.VITE_SERVICE_ERROR_MSG;
  const HelloMessage = __myapp.env.VITE_WELCOME_MSG;
  const ThumbUpReactsMessage = __myapp.env.VITE_BOT_REACTS_THUMB_UP;
  const ThumbDownReactsMessage = __myapp.env.VITE_BOT_REACTS_THUMB_DOWN;
  const QuestionUnknown = __myapp.env.VITE_QUESTION_UNKNOWN;
  const FindMatchingPrompt = __myapp.env.VITE_FIND_MATCHING_PROMPT;
  const ApiErrorMessage = __myapp.env.VITE_SERVICE_ERROR_MSG;
  const CommonWords = __myapp.env.VITE_COMMON_WORDS;
  const ContextQuery = __myapp.env.VITE_CONTEXT_QRY;
  const Message = __myapp.env.VITE_ENTRY_MSG;
  const ApiKey = __myapp.env.API_KEY

  //#endregion

  //#region 3. globals

  let entryIsVisible: boolean = false;
  let modalIsVisible: boolean = false;

  let isOnError: boolean = false;
  let messagesComponent: Messages;
  let messagesParentElement: HTMLElement;

  let promptElem: Input;
  let query = '';
  let queryCount = 0;
  
  let contextLoaded = false;
  let initialized = false;
  let ready = false;  
  //#endregion

  //#region 4. reactive
  $: isInitialized = initialized;
  $: isKnowledgeBaseLoaded = contextLoaded;
  $: isReady = contextLoaded && ($answer !== '...' || queryCount > 0);
  $: isProcessing = $answer === '...';
  $: isOnError = $chatMessages.messages.some((o) => o.role === 'system');
  $: if ($chatMessages.messages && messagesParentElement) {
    if(messagesComponent) messagesComponent.scroll();
  }
  //#endregion

  //#region 5. life-cycle

  onMount(init);

  afterUpdate(update);

  //#endregion

  //#region 6. private

  async function init(){
    // setContext();

    const initProm = chatMessages.init(
      QuestionIntro,
      QuestionText,
      QuestionTextEnd,
      QuestionUnknown,
      FindMatchingPrompt,
      ThumbUpMessage,
      ThumbDownMessage,
      ThumbUpReactsMessage,
      ThumbDownReactsMessage,
      ApiErrorMessage,
      CommonWords,
      ContextQuery,
      HelloMessage,
      ApiKey
    );

    initProm.then((res) => {
      initialized = true;
      contextLoaded = res;
    });

    // promptElem.focus();
  }

  async function update() {
    if(messagesComponent) messagesComponent.scroll();
  }

  const setContext = () => {
    const contextQuery = __myapp.env.VITE_CONTEXT_QRY;
  };

  const handleEntryClose = (event: any) => {
    entryIsVisible = false;
  };

  const handleSubmit = async () => {
    queryCount++;
    answer.set('...');
    await chatMessages.set(query);
    query = '';
  };

  const handleReset = async () => {
    chatMessages.reset();
  };

  const handleQuestion = async (event: any) => {
    query = event.detail.text;
    handleSubmit();
  };

  //#endregion
  
</script>

<!-- Loader while initializing -->
{#if !isInitialized}
  <Loader />
{/if}

{#if isInitialized && !isKnowledgeBaseLoaded}
  <h1 class="text-orange-800">Error: unable to initialize the knowledge base!</h1>
{/if}

<div
  id="background"
  tabindex="-1"
  class="background"
>

  <!-- All ready to go / open -->  
  {#if isKnowledgeBaseLoaded && modalIsVisible}
    <div
      id="popup-modal"
      tabindex="-1"
      class="main overflow-x-hidden overflow-y-auto"
    >
      <div class="relative w-full h-full">
        <div
          class="main_div_third relative flex items-center justify-center w-full h-full bg-white border border-sky-500 shadow"
        >
          <section class="main_section flex items-center w-full h-full justify-center flex-col">
            
            <!-- Top panel: FAQs -->
            <FAQs on:question={handleQuestion} canDisplay={isReady} />

            <!-- Main: Conversation Area -->
            <div class="main_div_fourth flex flex-col w-full h-2/3 items-center ">
              {#if isReady}
                <div
                  bind:this={messagesParentElement}
                  class="main_div_fifth h-full w-full bg-white border border-sky-500 overflow-y-auto flex flex-col"
                >
                  <div class="main_div_sixth flex flex-col">

                    <Messages 
                      QuestionIntro={QuestionIntro}
                      QuestionText={QuestionText}
                      QuestionTextEnd={QuestionTextEnd}
                      isOnError={isOnError}
                      messagesParentElement={messagesParentElement}
                      bind:this={messagesComponent}
                      ThumbUpMessage={ThumbUpMessage}
                      ThumbDownMessage={ThumbDownMessage}
                      bind:query={query}
                      bind:queryCount={queryCount}
                      ThumbUpReactsMessage={ThumbUpReactsMessage}
                      ThumbDownReactsMessage={ThumbDownReactsMessage}
                      UrlToHumanChat={UrlToHumanChat}
                      HumanChatOption={HumanChatOption}
                    />                    

                    {#if isOnError}
                      <div class="main_div_reset inline-flex rounded-md shadow-sm mb-3" role="group">
                        <button
                          on:click={handleReset}
                          class="bg-transparent hover:bg-gray-500 mr-3 text-gray-700 font-semibold hover:text-white p-3 border border-gray-500 hover:border-transparent rounded"
                        >
                          <p>Reset</p>
                        </button>
                      </div>
                    {/if}
                  </div>
                </div>
              {/if} 
              {#if isReady}
                <form
                  class="flex w-full rounded-md gap-4 bg-white border border-sky-500 p-2 text-xl sm:text-base"
                  on:submit|preventDefault={handleSubmit}
                >
                  <Input
                    type="text"
                    bind:value={query}
                    disabled={isProcessing || isOnError}
                    class="w-full sm:text-base"
                    bind:this={promptElem}
                  />
                  <button
                    disabled={isProcessing || isOnError}
                    type="submit"
                    class="py-1.5 px-3.5 border ml-[-0.5rem] rounded-md text-black bg-slate-300 hover:bg-gray-200 hover:text-gray-900"
                  >
                    <Send />
                  </button>
                </form>
              {/if}
            </div>
          </section>
        </div>
      </div>
    </div>
   
  {/if}

</div>

<OpenCloseButton bind:modalIsVisible={modalIsVisible} bind:entryIsVisible={entryIsVisible}/>